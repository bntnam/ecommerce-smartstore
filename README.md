<h1>SmartStore Web Application</h1>
<h3>1. Introduction</h3>
<p>- SmartStore is a website for selling smartphones with the full features for an e-commerce application.</p>
<h3>2. Technologies</h3>
<ul>
    <li><strong>Backend:</strong> Java, Spring (Spring Boot, Spring MVC, Spring Data JPA, Spring Security), Hibernate/JPA.</li>
    <li><strong>Frontend:</strong> HTML, CSS, JavaScript, Bootstrap, Thymleaf and some libraries/tools.</li>
    <li><strong>Database:</strong> MySQL.</li>
</ul>
<h3>3. Features</h3>
<p>- There are 2 parts of the project: User and Admin.</p>
<p>- I created sample User and Admin to let you take a look easier :</p>
<p><strong>a) User:</strong></p>
<p>+ ID: user</p>
<p>+ Password: user</p>
<ul>
    <li>You can create an account, update information, change password and forget password. Your password will be sent automatically to your registered email.</li>
    <li>Add your shipping address, billing address, card payment information.</li>
    <li>Search for the phones and add them into your shopping cart, then place an order. The verified order will send to your registered email.</li>
</ul>
<p><strong>b) Admin:</strong></p>
<p>+ ID: admin</p>
<p>+ Password: admin</p>
<ul>
    <li>You can only access admin page with admin ID (the access would be denied if you tried to access with user ID)</li>
    <li>After accessing admin portal, you can add new phones, edit and delete.</li>
</ul>
<h3>4. Architecture</h3>
<p>- Entity-Relationship Diagram</p>
<img class="img-fluid text-center" src="http://bntnam.com/img/portfolio/entity-relationship-diagram.png">
