<h1>Nam's Ecommerce Bookstore</h1>
<img class="img-fluid" src="https://bntnam.github.io/img/portfolio/bntn-ecommerce-bookstore.png" alt="">
<h3>1. Introduction</h3>
<p>- User interface: <a href="https://bntn-ecommerce-bookstore.herokuapp.com/">https://bntn-ecommerce-bookstore.herokuapp.com</a></p>
<p>- Admin portal: <a href="https://bntn-ecommerce-bookstore.herokuapp.com/admin">https://bntn-ecommerce-bookstore.herokuapp.com/admin</a></p>
<p>(Note: Please note that maybe some functions do not work properly because of the hosting, the time of deployment, etc. <br/>I just show my understanding and my codebase of the project.)</p>
<p>- Source Code: <a href="https://github.com/bntnam/bntn-ecommerce-bookstore">https://github.com/bntnam/bntn-ecommerce-bookstore</a></p>
<p>- The Webapp and Database are deployed on free hosting Heroku. Therefore, it's gonna take longer at the first time loading. Afterthat, the webapp will run normally.</p>
<h3>2. Technologies</h3>
<p>- Technology: (note that here I focused on backend more, because my field is Java)</p>
<ul>
    <li><strong>Backend:</strong> Java, Spring (Spring Boot, Spring MVC, Spring Data JPA, Spring Security), Hibernate/JPA.</li>
    <li><strong>Frontend:</strong> HTML, CSS, JavaScript, Bootstrap, Thymleaf and some libraries/tools.</li>
    <li><strong>Database:</strong> MySQL.</li>
    <li><strong>Hosting:</strong> Heroku.</li>
</ul>
<h3>3. Feature</h3>
<p>- There are 2 parts of the project: User and Admin.</p>
<p>- I created sample User and Admin to let you take a look easier :</p>
<p><strong>a) User:</strong></p>
<p>+ ID: user</p>
<p>+ Passowrd: user</p>
<ul>
    <li>You can create an account, update information, change password and forget password. Your password will be sent automatically to your registered email.</li>
    <li>Add your shipping address, billing address, card payment information.</li>
    <li>Search for the books and add them into your shopping cart, then place an order. The verified order will send to your registered email.</li>
</ul>
<p><strong>b) Admin:</strong></p>
<p>+ ID: admin</p>
<p>+ Passowrd: admin</p>
<ul>
    <li>You can only access admin page with admin ID (the access would be denied if you tried to access with user ID): <a href="https://bntn-ecommerce-bookstore.herokuapp.com/admin">https://bntn-ecommerce-bookstore.herokuapp.com/admin</a> </li>
    <li>After accessing admin portal, you can add new books, edit and delete.</li>
</ul>
<h3>4. Architecture</h3>
<p>- Entity-Relationship Diagram</p>
<img class="img-fluid text-center" src="https://bntnam.github.io/img/portfolio/entity-relationship-diagram.png">
