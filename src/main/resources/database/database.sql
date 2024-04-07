CREATE DATABASE IF NOT EXISTS `bookstore`;

USE `bookstore`;

CREATE TABLE `user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `enabled` INT NOT NULL,
    `accountNonExpired` INT NOT NULL,
    `credentialsNonExpired` INT NOT NULL,
    `accountNonLocked` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_UNIQUE` (`username`)
);

CREATE TABLE `Role` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `isEnabled` INT NOT NULL,
    `authority` VARCHAR(255) NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `User` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE `media` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `path` VARCHAR(255) NOT NULL,
    `type` VARCHAR(50),
    `size` INT CHECK(size > 0),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `customer` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `avatarId` INT,
    `fullname` VARCHAR(100),
    `phone` VARCHAR(10),
    `email` VARCHAR(100) NOT NULL,
    `birthday` DATE,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`avatarId`) REFERENCES `media` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `admin` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `fullname` VARCHAR(100),
    `phone` VARCHAR(15),
    `email` VARCHAR(100) NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `address` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `customerId` INT NOT NULL,
    `phone` VARCHAR(15),
    `address` VARCHAR(255),
    `street` VARCHAR(100),
    `ward` VARCHAR(100),
    `district` VARCHAR(100),
    `city` VARCHAR(100),
    `country` VARCHAR(100),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `category` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `language` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `code` VARCHAR(10),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `author` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `publisher` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255),
    `phone` VARCHAR(50),
    `email` VARCHAR(255),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `voucher` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `code` VARCHAR(50) NOT NULL,
    `description` VARCHAR(255),
    `discount` FLOAT NOT NULL CHECK(discount >= 0),
    `quantity` INT NOT NULL CHECK(quantity >= 0),
    `priceMinimumApplied` BIGINT CHECK(priceMinimumApplied >= 0),
    `priceMaximumApplied` BIGINT CHECK(priceMaximumApplied > 0),
    `expirationDate` TIMESTAMP,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `book` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT,
    `size` VARCHAR(50),
    `authorId` INT,
    `publisherId` INT,
    `languageId` INT,
    `categoryId` INT,
    `voucherId` INT,
    `thumbnailId` INT,
    `pages` INT CHECK(pages > 0),
    `weight` INT CHECK(weight > 0),
    `price` BIGINT CHECK(price >= 0),
    `discount` FLOAT CHECK(discount >= 0),
    `purchases` INT CHECK(purchases >= 0),
    `rate` INT CHECK(rate >= 0),
    `releaseDate` DATE,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`authorId`) REFERENCES `author` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (`publisherId`) REFERENCES `publisher` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (`languageId`) REFERENCES `language` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (`voucherId`) REFERENCES `voucher` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (`thumbnailId`) REFERENCES `media` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `bookMedia` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `bookId` INT NOT NULL,
    `mediaId` INT NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`mediaId`) REFERENCES `media` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `blog` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `authorId` INT NOT NULL,
    `thumbnailId` INT,
    `title` VARCHAR(255) NOT NULL,
    `content` TEXT NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`authorId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`thumbnailId`) REFERENCES `media` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `cart` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `customerId` INT NOT NULL,
    `quantity` INT NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `cartProduct` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `cartId` INT NOT NULL,
    `bookId` INT NOT NULL,
    `quantity` INT NOT NULL CHECK(quantity > 0),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cartId`) REFERENCES `cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `order` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `customerId` INT NOT NULL,
    `addressId` INT NOT NULL,
    `orderStatus` INT NOT NULL,
    `paymentStatus` INT NOT NULL,
    `shippingStatus` INT NOT NULL,
    `totalPrice` BIGINT NOT NULL CHECK(totalPrice >= 0),
    `shippingCost` BIGINT NOT NULL CHECK(shippingCost >= 0),
    `discount` BIGINT NOT NULL CHECK(discount >= 0),
    `totalPayment` BIGINT NOT NULL CHECK(totalPayment >= 0),
    `paymentMethod` VARCHAR(255),
    `shippingUnit` VARCHAR(255),
    `shippingMethod` VARCHAR(255),
    `shipperPhone` VARCHAR(20),
    `orderDate` TIMESTAMP,
    `estimatedArrival` TIMESTAMP,
    `deliveredAt` TIMESTAMP,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`),
    FOREIGN KEY (`addressId`) REFERENCES `address` (`id`)
);

CREATE TABLE `orderProduct` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `orderId` INT NOT NULL,
    `bookId` INT NOT NULL,
    `quantity` INT NOT NULL CHECK(quantity > 0),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`orderId`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `review` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `bookId` INT NOT NULL,
    `customerId` INT NOT NULL,
    `stars` INT NOT NULL CHECK(stars > 0 AND stars <= 5),
    `comment` VARCHAR(255),
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`bookId`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `reviewMedia` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `reviewId` INT NOT NULL,
    `mediaId` INT NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`reviewId`) REFERENCES `review` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`mediaId`) REFERENCES `media` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `slide` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `thumbnailId` INT NOT NULL,
    `caption` VARCHAR(255) NOT NULL,
    `content` VARCHAR(1500),
    `link` VARCHAR(255) NOT NULL,
    `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdBy` VARCHAR(100),
    `modifiedBy` VARCHAR(100),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`thumbnailId`) REFERENCES `media` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);