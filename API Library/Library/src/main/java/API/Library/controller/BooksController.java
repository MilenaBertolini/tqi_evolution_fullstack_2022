package API.Library.controller;

import API.Library.entities.Books;
import API.Library.entities.Sales;
import API.Library.entities.Transactions;
import API.Library.model.BooksModel;
import API.Library.model.ClientModel;
import API.Library.model.TransactionsModel;
import API.Library.repository.ClientRepository;
import API.Library.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import API.Library.repository.BooksRepository;

import javax.xml.bind.DatatypeConverter;

@RestController
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;


    @GetMapping(path = "/api/books/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        return booksRepository.findById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/books/allBooks")
    public ResponseEntity getAllBooks() {
        return ResponseEntity.ok().body(booksRepository.findAll());
    }


    @PostMapping(path = "/api/books/insert")
    public BooksModel insert(@RequestBody Books books) {
        BooksModel booksModel = new BooksModel();
        booksModel.setAuthor(books.getAuthor());
        booksModel.setImage(DatatypeConverter.parseBase64Binary(books.getImage()));
        booksModel.setPublisher(books.getPublisher());
        booksModel.setPrice(books.getPrice());
        booksModel.setQuantity(books.getQuantity());
        booksModel.setTitle(books.getTitle());
        booksModel.setPublishYear(books.getPublishYear());
        return booksRepository.save(booksModel);
    }

    @PostMapping(path = "/api/books/sell")
    public TransactionsModel saleBooks(@RequestBody Sales sale) {

        BooksModel book = booksRepository.findById(sale.getTransactions().getIdProduct()).get();
        book.setQuantity(book.getQuantity() - sale.getTransactions().getQuantity());
        booksRepository.save(book);

        ClientModel client = new ClientModel();
        client.setCpf(sale.getClient().getCpf());
        client.setName(sale.getClient().getName());
        client = clientRepository.save(client);

        TransactionsModel saleTransaction = new TransactionsModel();
        saleTransaction.setBuy(false);
        saleTransaction.setSell(true);
        saleTransaction.setPrice(sale.getTransactions().getPrice());
        saleTransaction.setQuantity(sale.getTransactions().getQuantity());
        saleTransaction.setIdClient(client.getId());
        saleTransaction.setIdProduct(sale.getTransactions().getIdProduct());

        return transactionsRepository.save(saleTransaction);
    }

    @PostMapping(path = "/api/books/buy")
    public TransactionsModel buyBooks(@RequestBody Transactions buy) {

        BooksModel book = booksRepository.findById(buy.getIdProduct()).get();
        book.setQuantity(book.getQuantity() + buy.getQuantity());
        booksRepository.save(book);

        TransactionsModel buyModel = new TransactionsModel();
        buyModel.setBuy(true);
        buyModel.setSell(false);
        buyModel.setIdProduct(buy.getIdProduct());
        buyModel.setQuantity(buy.getQuantity());
        buyModel.setPrice(buy.getPrice());

        return transactionsRepository.save(buyModel);
    }

    @GetMapping(path = "/api/books/allTransactions")
    public ResponseEntity getAllTransaction() {
        return ResponseEntity.ok().body(transactionsRepository.findAll());
    }

    @GetMapping(path = "/api/books/allClients")
    public ResponseEntity getAllClients() {
        return ResponseEntity.ok().body(clientRepository.findAll());
    }

}
