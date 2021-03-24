Access project 
================================
1. clone the project and create the postgres database with test name in application.property file 
2. remove package "com.ab.data.contact.db" and "com.ab.data.contact.db.repo" from project
3. run command from terminal for Linux

```bash
$ ./gradlew clean classes build -x test cleanEclipse eclipse
$ ./gradlew --no-daemon run
```
for windows run bellow command 


```bash
$ gradlew.bat clean classes build -x test cleanEclipse eclipse
$ gradlew.bat --no-daemon run
```

Api for contect model
```bash
method: POST
url: http://localhost:8081/ab-data/ws/action/
body : {
    "action": "com.ab.data.db.web.ContactActionController:saveContactRecord",
		"data" :{
    "lastName": "test",
    "houseNumber": "433",
    "zipcode": "12345",
    "firstName": "test",
    "street": "Altendorfer str.",
    "email": "test@gmail.com"
	}
}
```
