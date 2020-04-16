## Contents

- [HttpCon](#httpcon)
- [Pair](#pair)
- [Random](#random)
- [TextFile](#textfile)

<br />

## HttpCon 
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp; 
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &nbsp; &nbsp; [(Back to contents)](#contents)

### Construct an HTTP request (full example):
```
String url = "https://www.example.com";
String[] headers = new String[]{"Content-type: application/xml"};
String data = TextFile.fileToString(xmlFilePath);
final HttpCon.Request r = new HttpCon.Request(HttpCon.Type.POST, url, headers, data);
```

### Execute an HTTP request directly and print the response:
```
System.out.println(HttpCon.request(..));
```
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; or
```
System.out.println(new HttpCon.Request(..));
```

### Execute a pre-established HTTP request and print the response:
```
final HttpCon.Request r = new HttpCon.Request(..);
String res = HttpCon.exec(r);
System.out.println(res);
```
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; or
```
final HttpCon.Request r = new HttpCon.Request(..);
System.out.println(r);
```

### Execute a request and save the response in a file:
```
final HttpCon.Request r = new HttpCon.Request(..);
TextFile.stringToFile(r, filePath);
```

<br />

## Pair
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp; 
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &nbsp; &nbsp; [(Back to contents)](#contents)

```
Pair<int,int> primes = new Pair<>(7, 91);
int sumOfPrimes = primes.first + primes.second;
```

<br />

## Random
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp; 
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &nbsp; &nbsp; [(Back to contents)](#contents)

### Generate a random integer in a range:
```
int randInt = Random.genInt(1, 10);
```

### Generate random decimals within a range:
```
double[] randDoubles = Random.genDoubles(5, 1.5, 10.5);
```

<br />

## TextFile
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp; 
&emsp; &emsp; &emsp; &emsp;
&emsp; &emsp; &emsp; &emsp;
&emsp; &nbsp; &nbsp; [(Back to contents)](#contents)

### Write text in a file:
```
/* Third argument to append or overwrite if existing */
TextFile.stringToFile("Statistiques personnage :", filePath, false);
TextFile.stringToFile(personnage, filePath, true);
```

### Get text from a file:
```
String fileContent = TextFile.fileToString(filePath);
```

### Print a file overview:
```
/* Second argument to set the number of lines to get */
System.out.println(TextFile.overview(filePath, 10));
```
