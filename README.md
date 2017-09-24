# SpringCloudStreamSample
Proyecto de prueba de SpringCloudStream para RabbitMQ

* Este proyecto es un productor/consumidor de "greeting". 
* Se ha definido un grupo para que todas las instancias levantadas de esta aplicación compitan por consumir cada "greeting".
* Se han definido 4 particiones, para direccionar los mensajes en función del "greeting.user".
* Para arrancar cada instancia, se le ha de definir el indice de la partición que representa:    
  * mvn spring-boot:run -D spring.cloud.stream.bindings.greeting_input_channel.consumer.instanceIndex=<indice de 0..3>
