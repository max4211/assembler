<%--
  Created by IntelliJ IDEA.
  User: smith
  Date: 4/17/2020
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="utf-8">
  <meta name="description" content="I am an assembler/base converter tool">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="keywords" content="assembler, ece, Board, digital">
  <meta name="author" content="Max Smith">
  <title>ECE350 Assembler</title>
  <link rel="shortcut icon" type="image/png" href="img/icon.png">
  <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<div class="header">
  <img src="img/duke_ece.PNG">
</div>
<div class="hidden">
  <p>Written by: Max Smith</p>
  <p>Mentored by: Nathan Choe</p>
  <p>Lab TA: David Miron</p>
  <p>Professor: Dr. Board</p>
</div>
<div class="instructions">
  <p>Please upload a mips file (.s format), select the desired output base and file type and then hit Translate</p>
</div>
<div class="form-div" id="translate-form">
  <h1>Assembler</h1>
  <form action="AssemblerServlet" method="post">
    <label for="myfile">Select a file:</label>
    <input type="file" id="myfile" name="myfile"><br>
    <p>Output File Options:</p>
    <select id="output-type">
      <option value="mif">Mif</option>
      <option value="logism">Logism</option>
      <option value="txt">Text</option>
    </select>
    <select id="output-base">
      <option value="hex">16 (hex)</option>
      <option value="bin">2 (binary)</option>
      <option value="dec">10 (decimal)</option>
    </select><br>
    <input type="submit" value="Assemble" id="translate-tag" class="submit-btn"><br><br>
  </form>
</div>
<div class="instructions">
  <p>Please enter the number you would like to convert, and select its input base and target base, then select Convert.</p>
</div>
<div class="form-div" id="convert-form">
  <h1>Base Converter</h1>
  <form action="">
    <p>Number:</p>
    <input type="text" id="input-convert">
    <p>From base:</p>
    <select id="input-base">
      <option value="bin">2 (binary)</option>
      <option value="hex">16 (hex)</option>
      <option value="dec">10 (decimal)</option>
    </select><br>
    <p>To base:</p>
    <select id="target-base">
      <option value="hex">16 (hex)</option>
      <option value="bin">2 (binary)</option>
      <option value="dec">10 (decimal)</option>
    </select><br>
    <p>Output Value</p>
    <input type="text" id="output-convert" name="myfile"><br>
    <input type="submit" value="Convert" id="convert-tag" class="submit-btn">
  </form>
</div>
</body>

</html>
