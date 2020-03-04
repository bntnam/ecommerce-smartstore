# SmartStore Web Application

<img class="img-fluid text-center" src="http://bntnam.com/img/portfolio/ecommerce-smartstore.png" alt="ecommerce smartstore image" />

### 1. Introduction

- SmartStore is a website for selling smartphones with the full features for an e-commerce application.

### 2. Technologies

- **Backend:** Java, Spring (Spring Boot, Spring MVC, Spring Data JPA, Spring Security), Hibernate/JPA.
- **Frontend:** HTML, CSS, JavaScript, Bootstrap, Thymleaf and some libraries/tools.
- **Database:** MySQL.

### 3. Features

**User:**

```
ID: user
Password: user
```

- You can create an account, update information, change password and forget password. Your password will be sent automatically to your registered email.
- Add your shipping address, billing address, card payment information.
- Search for the phones and add them into your shopping cart, then place an order. The verified order will send to your registered email.

**Admin:**

```
ID: admin
Password: admin
```
- You can only access admin page with admin ID (the access would be denied if you tried to access with user ID)
- After accessing admin portal, you can add new phones, edit and delete.

### 4. Architecture

- Entity-Relationship Diagram

<img class="img-fluid text-center" src="http://bntnam.com/img/portfolio/entity-relationship-diagram.png" alt="entity relationship diagram" />
