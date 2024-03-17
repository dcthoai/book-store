CREATE DATABASE BookStore CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE BookStore;

CREATE TABLE Administrators (
	adminID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(25) unique NOT NULL,
    email VARCHAR(64) unique NOT NULL,
    pass VARCHAR(255) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE Media (
	mediaID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mediaName VARCHAR(255) NULL,
    mediaPath VARCHAR(255) NOT NULL,
    mediaType VARCHAR(10) NOT NULL,
    mediaSize INT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE Voucher(
	voucherID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    voucherName VARCHAR(64) NOT NULL,
    voucherCode VARCHAR(20) NOT NULL,
    descriptions VARCHAR(255) NULL,
    discount FLOAT NOT NULL CHECK(discount BETWEEN 0 AND 100),
    quantity INT NOT NULL CHECK(quantity >= 0),
    priceMinimumApplied BIGINT NULL CHECK(priceMinimumApplied >= 0),
    priceMaximumApplied BIGINT NULL CHECK(priceMaximumApplied > 0),
    expirationDate TIMESTAMP NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE Customer (
	customerID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(25) UNIQUE NOT NULL,
    phoneNumber CHAR(10) UNIQUE NOT NULL,
    fullname VARCHAR(64) NULL,
    email VARCHAR(64) unique NOT NULL,
    pass VARCHAR(255) NOT NULL,
    avatar INT NULL,
    birthday DATE NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE Address (
	addressID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerID INT NOT NULL,
    phoneNumber CHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    street VARCHAR(50) NULL,
    ward VARCHAR(50) NULL,
    district VARCHAR(50) NULL,
    city VARCHAR(50) NULL,
    country VARCHAR(50) NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Address_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE
);

CREATE TABLE Category (
	categoryId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    categoryName VARCHAR(255) NOT NULL,
    descriptions VARCHAR(1000) NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE Languages (
	languageID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    languageName VARCHAR(64) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE Book (
	bookID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(64) NULL,
    publisher VARCHAR(64) NULL,
    size VARCHAR(64) NULL,
    descriptions VARCHAR(3000) NULL,
    categoryID INT NULL,
    thumbnail INT NULL,
    languageID INT NULL,
    voucherID INT NULL,
    ageLimit INT NULL CHECK(ageLimit > 0),
    pages INT NULL CHECK(pages > 0),
    weight INT NULL CHECK(weight > 0),
    discount FLOAT NOT NULL CHECK(discount BETWEEN 0 AND 100),
    price BIGINT NOT NULL CHECK(price >= 0),
    releaseDate DATE NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Book_Category FOREIGN KEY (categoryID) REFERENCES Category(categoryID) ON DELETE SET NULL,
    CONSTRAINT FK_Book_Languages FOREIGN KEY (languageID) REFERENCES Languages(languageID) ON DELETE SET NULL,
    CONSTRAINT FK_Book_Media FOREIGN KEY (thumbnail) REFERENCES Media(mediaID) ON DELETE SET NULL,
    CONSTRAINT FK_Book_Voucher FOREIGN KEY (voucherID) REFERENCES Voucher(voucherID) ON DELETE SET NULL
);

CREATE TABLE BookMedia (
    bookID INT NOT NULL,
    mediaID INT NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    PRIMARY KEY (bookID, mediaID),
    CONSTRAINT FK_BookMedia_Book FOREIGN KEY (bookID) REFERENCES Book(bookID) ON DELETE CASCADE,
    CONSTRAINT FK_BookMedia_Media FOREIGN KEY (mediaID) REFERENCES Media(mediaID) ON DELETE CASCADE
);

CREATE TABLE Cart (
	cartID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerID INT NOT NULL,
    totalPayment BIGINT NULL,
    quantity INT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Cart_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE
);

CREATE TABLE CartProduct (
    cartID INT NOT NULL,
    bookID INT NOT NULL,
    quantity INT NOT NULL CHECK(quantity > 0),
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    PRIMARY KEY (cartID, bookID),
    CONSTRAINT FK_CartProduct_Cart FOREIGN KEY (cartID) REFERENCES Cart(cartID) ON DELETE CASCADE,
    CONSTRAINT FK_CartProduct_Book FOREIGN KEY (bookID) REFERENCES Book(bookID) ON DELETE CASCADE
);

CREATE TABLE Orders (
	orderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerID INT NOT NULL,
    orderDate DATE NOT NULL,
    orderStatus VARCHAR(25) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Orders_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE
);

CREATE TABLE OrderProduct (
    orderID INT NOT NULL,
    bookID INT NOT NULL,
    quantity INT NOT NULL CHECK(quantity > 0),
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    PRIMARY KEY (orderID, bookID),
    CONSTRAINT FK_OrderProduct_Orders FOREIGN KEY (orderID) REFERENCES Orders(orderID) ON DELETE CASCADE,
    CONSTRAINT FK_OrderProduct_Book FOREIGN KEY (bookID) REFERENCES Book(bookID) ON DELETE CASCADE
);

CREATE TABLE Payment (
	paymentID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderID INT NOT NULL,
    customerID INT NOT NULL,
    total BIGINT NOT NULL CHECK(total >= 0),
    paymentMethod VARCHAR(25) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Payment_Orders FOREIGN KEY (orderID) REFERENCES Orders(orderID) ON DELETE CASCADE,
    CONSTRAINT FK_Payment_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE
);

CREATE TABLE Shipping (
	shippingID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerID INT NOT NULL,
    orderID INT NOT NULL,
    shippingAddress VARCHAR(255) NOT NULL,
    shippingUnit VARCHAR(50) NOT NULL,
    shippingMethod VARCHAR(50) NOT NULL,
    shippingStatus VARCHAR(50) NULL DEFAULT 'Đang xử lý',
    shipperPhone VARCHAR(10) NULL,
    shippingCost BIGINT NOT NULL CHECK(shippingCost >= 0),
    estimatedArival DATE NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Shipping_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE,
    CONSTRAINT FK_Shipping_Orders FOREIGN KEY (orderID) REFERENCES Orders(orderID) ON DELETE CASCADE
);

CREATE TABLE Review (
	reviewID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bookID INT NOT NULL,
    customerID INT NOT NULL,
    stars INT NOT NULL,
    comments VARCHAR(255) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Review_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE,
    CONSTRAINT FK_Review_Book FOREIGN KEY (bookID) REFERENCES Book(bookID) ON DELETE CASCADE,
    CONSTRAINT Unique_Review_Customer_Book UNIQUE (customerID, bookID)
);

CREATE TABLE ReviewtMedia (
    reviewID INT NOT NULL, 
    mediaID INT NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    PRIMARY KEY (reviewID, mediaID),
    CONSTRAINT FK_ReviewMedia_Media FOREIGN KEY (mediaID) REFERENCES Media(mediaID) ON DELETE CASCADE,
    CONSTRAINT FK_ReviewMedia_Review FOREIGN KEY (reviewID) REFERENCES Review(reviewID) ON DELETE CASCADE
);

CREATE TABLE Slide(
	slideId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    slideMedia INT NOT NULL,
    caption VARCHAR(255) NULL,
    content VARCHAR(255) NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL,
    CONSTRAINT FK_Slide_Media FOREIGN KEY (slideMedia) REFERENCES Media(mediaID) ON DELETE CASCADE
);