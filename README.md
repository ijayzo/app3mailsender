# app3 mailsender

Run com.example.demo.DemoApplication as a Java Application.

Runs on port of Spring Boot - 8070

API usage

- http://localhost:8070/mailapi/sendTestEmail

```txt
Test Email sent successfully
```

- http://localhost:8070/mailapi/sendCancelEmail
- JSON Body: {
  "emailTo": "noel.gopez@revature.net",
  "cancelReason": "unforseen issues with the supplier",
  "packageDesc": "Super Awesome Miami Beach Package"
  }

```txt
Email sent successfully to noel.gopez@revature.net
```
monitoring API
- http://localhost:8070/actuator/health

```json
{"status":"UP"}
```

- http://localhost:8070/actuator/prometheus
```properties
# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management
# TYPE jvm_memory_max_bytes gauge
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'profiled nmethods'",} 1.2288E8
jvm_memory_max_bytes{area="heap",id="G1 Survivor Space",} -1.0
jvm_memory_max_bytes{area="heap",id="G1 Old Gen",} 3.185573888E9
jvm_memory_max_bytes{area="nonheap",id="Metaspace",} -1.0
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'non-nmethods'",} 5898240.0
jvm_memory_max_bytes{area="heap",id="G1 Eden Space",} -1.0
```