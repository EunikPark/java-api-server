cd rootjava-api-server 


mvn spring-bootrun &
.grpcwebproxy-v0.15.0-linux-x86_64 --backend_addr=localhost6565 --backend_tls_noverify --run_tls_server=false --allow_all_origins --server_http_debug_port=8081 &