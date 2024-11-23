<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="bank.*"
    import ="java.util.*"
   %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>APANA - BANK | Extraordinary Service</title>
    <link rel="stylesheet" href="main.css">
    <style type="text/css">
         #new
         {
           
            width : 730px;
            color: black;
            font-family: sans-serif;
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
        <div id="new">
         <%
               CustomerBean cb= (CustomerBean)application.getAttribute("cbean");
               String msg = (String)request.getAttribute("msg");
            		
            		Date ld = new Date();
            		if(msg!=null)
            		{
            			out.println(msg);
            		}
            		else
            		{
            			long bal = (long)request.getAttribute("bal");
            			out.println("WithDraw Successfull....<br>");
            			out.println( bal+" Debitate to  Your  Account on "  + ld);
            			out.println("<br>Available Balance is : "+ cb.getAmount());
            		}
            %>
            
         
            
        </div>
    </div>
</body>
</html>
