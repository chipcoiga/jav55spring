INSERT INTO category(id, name, description) VALUES (1, 'Fiction', 'Fiction books');
INSERT INTO category(id, name, description) VALUES (2, 'Technology', 'IT books');

INSERT INTO book(id, name, author, category_id) VALUES (1, 'Spring in Action', 'Craig Walls', 2);
INSERT INTO book(id, name, author, category_id) VALUES (2, 'Harry Potter', 'J.K. Rowling', 1);

INSERT INTO bookdetails(id, isbn, number_of_page, price, publish_date) VALUES
                                                                           (1, '9781617294945', 450, 500000, '2020-01-15'),
                                                                           (2, '9780747532743', 300, 350000, '2001-07-08');
