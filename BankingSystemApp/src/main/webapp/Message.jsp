<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>APANA - BANK | Extraordinary Service</title>
    <link rel="stylesheet" href="main.css">
    <style type="text/css">
     #msg
     { 
       color : red;
       font-size: large;
     }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo">
            <h1>APANA - BANK</h1>
            <h2>ExtraOrdinary Service</h2>
        </div>
        <nav class="navbar">
            <a href="Index.html">Home</a>
            <a href="NewAccount.html">New Account</a>
            <a href="Balance.html">Balance</a>
            <a href="Deposit.html">Deposit</a>
            <a href="Withdraw.html">Withdraw</a>
            <a href="Transfer.html">Transfer</a>
            <a href="Close.html">Close AC</a>
            <a href="About.html">About Us</a>
        </nav>
    </div>
    
    <div class="content">
        <div class="section">
            <h3>Results</h3>
            <p>This is Global Business Bank, which is under business and finance category for worldwide design.</p>
        </div>
        <div class="section">
            <h3>Opportunities</h3>
            <p>This Global Business Bank would be ideal for building a successful online business.</p>
        </div>
        <div class="section">
            <h3>Solutions</h3>
            <p>There are various other templates categorized in business, finance, etc.</p>
        </div>
    </div>

    <div class="footer">
        <div class="services">
            <h3>Services</h3>
            <a href="">www.apna.com</a><br>
            <a href="">www.apna.com</a><br>
            <a href="">www.apna.com</a><br>
        </div>
        <div class="welcome">
             
            <h3>New Account Form</h3>
             <div id= "msg">
             
             <%
                  String msg = (String)request.getAttribute("msg");
            		out.println(msg);
              %>
              </div>
            <form action="new" method="post">
                User Name: <input type="text" name="uname"><br>
                Password: <input type="password" name="pword"><br>
                Re-password: <input type="password" name="repword"><br>
                Amount: <input type="number" name="amot"><br>
                Address: <input type="text" name="add"><br>
                Phone No: <input type="tel" name="phono"><br>
                <input type="submit"> <input type="reset">
            </form>
        </div>
        <div class="news-events">
             <h3>Welcome</h3>
            <img id="img" alt="" src="image/employee.jpg">
               <pre>Hello Dear  Customer Welcome to Apna Bank
      We  have  More offer to  our  Customer </pre>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const form = document.querySelector('form');

            form.addEventListener('submit', (event) => {
                const username = form.querySelector('input[name="uname"]').value.trim();
                const password = form.querySelector('input[name="pword"]').value;
                const repPassword = form.querySelector('input[name="repword"]').value;
                const amount = form.querySelector('input[name="amot"]').value.trim();
                const address = form.querySelector('input[name="add"]').value.trim();
                const phone = form.querySelector('input[name="phono"]').value.trim();

                if (!username || !password || !repPassword || !amount || !address || !phone) {
                    alert('Please fill out all fields.');
                    event.preventDefault(); // Prevent form submission
                    return;
                }

                if (password !== repPassword) {
                    alert('Passwords do not match.');
                    event.preventDefault(); // Prevent form submission
                    return;
                }

                alert('Form submitted successfully!');
            });
        });
    </script>
</body>
</html>
