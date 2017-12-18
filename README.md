# Musiyer
Un Service es un componente de una aplicación que puede realizar operaciones de larga ejecución en segundo plano y que no proporciona 
una interfaz de usuario. Otro componente de la aplicación puede iniciar un servicio y continuará ejecutándose en segundo plano aunque 
el usuario cambie a otra aplicación. Además, un componente puede enlazarse con un servicio para interactuar con él e incluso realizar 
una comunicación entre procesos (IPC). Por ejemplo, un servicio puede manejar transacciones de red, reproducir música, realizar I/O d
e archivos o interactuar con un proveedor de contenido, todo en segundo plano.

Un Service es un componente de una aplicación que puede realizar operaciones de larga ejecución en segundo plano y que no proporciona 
una interfaz de usuario. Otro componente de la aplicación puede iniciar un servicio y continuará ejecutándose en segundo plano aunque 
el usuario cambie a otra aplicación. Además, un componente puede enlazarse con un servicio para interactuar con él e incluso realizar 
una comunicación entre procesos (IPC). Por ejemplo, un servicio puede manejar transacciones de red, reproducir música, realizar I/O de 
archivos o interactuar con un proveedor de contenido, todo en segundo plano.

Un servicio puede adoptar esencialmente dos formas:

Servicio iniciado

Un servicio está "iniciado" cuando un componente de aplicación (como una actividad) lo inicia llamando a startService(). Una vez 
iniciado, un servicio puede ejecutarse en segundo plano de manera indefinida, incluso si se destruye el componente que lo inició. 
Por lo general, un servicio iniciado realiza una sola operación y no devuelve un resultado al emisor. Por ejemplo, puede descargar 
o cargar un archivo a través de la red. Cuando la operación está terminada, el servicio debe detenerse por sí mismo.

Servicio de enlace

Un servicio es de “de enlace” cuando un componente de la aplicación se vincula a él llamando a bindService(). Un servicio de enlace 
ofrece una interfaz cliente-servidor que permite que los componentes interactúen con el servicio, envíen solicitudes, obtengan 
resultados e incluso lo hagan en distintos procesos con la comunicación entre procesos (IPC). Un servicio de enlace se ejecuta 
solamente mientras otro componente de aplicación está enlazado con él. Se pueden enlazar varios componentes con el servicio a la vez,
pero cuando todos ellos se desenlazan, el servicio se destruye.
