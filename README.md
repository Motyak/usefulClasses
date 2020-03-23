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
System.out.println(r);
```

### Execute a request and save the response in a file:
```
final HttpCon.Request r = new HttpCon.Request(..);
TextFile.stringToFile(r, filePath);
```
