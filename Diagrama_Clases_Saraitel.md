# Diagrama de Clases — Saraitel

> Documentación generada a partir del archivo `Diagrama_Clases_Saraitel.xlsx`.

## Clases

| # | Clase | Estereotipo | Descripción |
|---|---|---|---|
| 1 | [Pais](#pais) | class | Representa el país al que pertenecen las sedes. |
| 2 | [MetodoPago](#metodopago) | class | Representa las formas en que un cliente puede cancelar una compra (efectivo, tarjeta, transferencia, Nequi, entre otras). |
| 3 | [Cliente](#cliente) | class | Representa a la persona que adquiere productos en cualquiera de las sedes del negocio. |
| 4 | [Marca](#marca) | class | Representa al fabricante de los accesorios y repuestos que comercializa el negocio. |
| 5 | [Motivo](#motivo) | class | Representa la razón por la que un cliente solicita devolver un producto. |
| 6 | [TipoDocumento](#tipodocumento) | class | Representa el tipo de documento de identidad de una persona |
| 7 | [Categoria](#categoria) | class | Representa la clasificación a la que pertenece un producto dentro del catálogo. |
| 8 | [Prefijo](#prefijo) | class | Representa el código de marcado telefónico asociado a un país para el registro de números de contacto |
| 9 | [Persona](#persona) | class | Representa a un individuo en el sistema con sus datos generales de identificación para registrarse en el sistema |
| 10 | [Producto](#producto) | class | Representa un artículo del catálogo general del negocio, independiente de la sede en la que se encuentre. |
| 11 | [Departamento](#departamento) | class | Representa el departamento o división administrativa al que pertenece una ciudad dentro de un país. |
| 12 | [ClienteRegistrado](#clienteregistrado) | class | Representa al cliente cuyos datos de identificación y contacto han sido registrados en el sistema |
| 13 | [ClienteNoRegistrado](#clientenoregistrado) | class | Representa a la persona que realiza una compra sin contar con un registro previo en el sistema |
| 14 | [ClienteRegistradoN](#clienteregistradon) | class | Representa al cliente registrado natural en el sistema con sus datos básicos de identificación y contacto |
| 15 | [ClienteRegistradoJ](#clienteregistradoj) | class | Representa al cliente registrado Jurídico en el sistema con sus datos básicos de identificación y contacto |
| 16 | [Ciudad](#ciudad) | class | Representa la ciudad o municipio donde se ubican las sedes del negocio y residen los clientes. |
| 17 | [Sede](#sede) | class | Representa cada local físico del negocio, donde se atienden las compras y se almacena la mercancía. |
| 18 | [IngresoInventario](#ingresoinventario) | class | Representa la factura de la llegada de nueva mercancía a una sede por parte de un proveedor que la creó previamente. |
| 19 | [Empleado](#empleado) | class | Representa al personal contratado que trabaja en una sede específica, es quien atiende las compras de los clientes. |
| 20 | [ProductoSede](#productosede) | class | Representa el inventario real de un producto en una sede determinada. |
| 21 | [Administrador](#administrador) | class | Representa la especialización del empleado con permisos administrativos sobre la operación del negocio. |
| 22 | [Vendedor](#vendedor) | class | Representa la especialización del empleado encargado de atender a los clientes en la sede. |
| 23 | [ProcesoCompra](#procesocompra) | class | Representa el flujo que controla los estados y transiciones de una compra. |
| 24 | [DetalleIngreso](#detalleingreso) | class | Representa el detalle de cada producto que entró de mercancía al negocio, su cantidad, precio y demás atributos. |
| 25 | [DetalleCompra](#detallecompra) | class | Representa el detalle de cada producto que se vendió en una sede específica, su cantidad, precio y demás atributos. |
| 26 | [Compra](#compra) | class | Representa la transacción en la que un cliente adquiere uno o varios productos en una sede, es atendida por un empleado. |
| 27 | [Pago](#pago) | class | Representa el abono que realiza el cliente para saldar una compra. |
| 28 | [Factura](#factura) | class | Representa el comprobante legal de venta que se genera a partir de una compra ya pagada |
| 29 | [Devolucion](#devolucion) | class | Representa la solicitud de un cliente de devolver un producto si cumple con las condiciones establecidas en el negocio. |
| 30 | [PagoNormal](#pagonormal) | class | Representa la especialización del pago realizado directamente por el cliente mediante un método de pago |
| 31 | [SaldoFavor](#saldofavor) | class | Representa el saldo a favor del cliente generado por una devolución de mercancía. |
| 32 | [AplicacionSaldo](#aplicacionsaldo) | class | Representa el uso de un saldo a favor sobre un pago con saldo, y permite controlar el saldo de un cliente específico. |

---

## Pais

**Descripción:** Representa el país al que pertenecen las sedes.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | Departamento |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del país |
| private | nombre | String | - | no final | no static | - | Nombre oficial del país |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Pais | Defecto | Constructor por defecto que crea una instancia de Pais sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Pais | Parametrizado | Constructor parametrizado que crea una instancia de Pais inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del país | No aplica |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre oficial del país |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del país | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre oficial del país | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | consultarTodosPaises | no static | no final | Permite consultar la información detallada de todos los países registrados | No aplica |  |  |  |  |  | Otro | List&lt;Pais&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar el catálogo de países |
| public | buscarPaisPorFiltro | no static | no final | Permite buscar un país determinado por un criterio específico (nombre, id) | filtro | Otro | Pais | Por valor | no final | Contiene la información de los filtros que servirán como base para llevar a cabo la consulta de la información | Otro | List&lt;Pais&gt; | Informar con un mensaje de error si los parámetros de filtro de consulta son inválidos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar el catálogo de países |

[↑ Volver al índice](#clases)

---

## MetodoPago

**Descripción:** Representa las formas en que un cliente puede cancelar una compra (efectivo, tarjeta, transferencia, Nequi, entre otras).

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | PagoNormal |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del método de pago |
| private | nombre | String | - | no final | no static | - | Nombre del método de pago disponible en el negocio |
| private | esActivo | boolean/Boolean | - | no final | no static | Si | Indica si el método de pago está disponible para utilizarse. |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | MetodoPago | Defecto | Constructor por defecto que crea una instancia de MetodoPago sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | MetodoPago | Parametrizado | Constructor parametrizado que crea una instancia de MetodoPago inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del método de pago | No aplica |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre del método de pago disponible en el negocio |  |
|  |  |  |  | esActivo | boolean/Boolean | - | Por valor | no final | Indica si el método de pago está disponible para utilizarse. |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del método de pago | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre del método de pago disponible en el negocio | void | - | No aplica |
| public | getEsActivo | getter | no final | Método encargado de obtener el valor del atributo esActivo | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setEsActivo | setter | no final | Método encargado de colocar el valor al atributo esActivo | valorEsActivo | boolean/Boolean | - | Por valor | no final | Indica si el método de pago está disponible para utilizarse. | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarMetodoPago | no static | no final | Permite agregar una nueva opción al catálogo de métodos de pago del sistema | datos | Otro | MetodoPago | Por valor | no final | Corresponde al nombre y estado del nuevo método de pago | Otro | MetodoPago | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un metodo de pago registrado con ese nombre |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si los parámetros de filtro de consulta son inválidos |
| public | consultarTodosMetodosPago | no static | no final | Permite buscar y visualizar los métodos de pago habilitados para realizar transacciones. | No aplica |  |  |  |  |  | Otro | List&lt;MetodoPago&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la lista de métodos de pago |
| public | consultarMetodosPagoPorFiltro | no static | no final | Permite buscar por filtro y visualizar los métodos de pago habilitados para realizar transacciones | filtro | Otro | MetodoPago | Por valor | no final | Los parámetros de búsqueda ingresados por el usuario para filtrar el catálogo | Otro | List&lt;MetodoPago&gt; | Informar con un mensaje de error si los parámetros de filtro de consulta son inválidos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la lista de métodos de pago |

[↑ Volver al índice](#clases)

---

## Cliente

**Descripción:** Representa a la persona que adquiere productos en cualquiera de las sedes del negocio.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | ClienteNoRegistrado |
| Es usada por | Asociación | ClienteRegistrado |
| Es usada por | Asociación | ProcesoCompra |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del cliente |
| private | clientePorDefecto | boolean/Boolean | - | no final | no static | No | Indica si la compra debe asociarse al cliente no registrado cuando el comprador no desea ser registrado en el sistema. |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Cliente | Defecto | Constructor por defecto que crea una instancia de Cliente sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Cliente | Parametrizado | Constructor parametrizado que crea una instancia de Cliente inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del cliente | No aplica |
|  |  |  |  | clientePorDefecto | boolean/Boolean | - | Por valor | no final | Indica si la compra debe asociarse al cliente no registrado cuando el comprador no desea ser registrado en el sistema. |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del cliente | void | - | No aplica |
| public | getClientePorDefecto | getter | no final | Método encargado de obtener el valor del atributo clientePorDefecto | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setClientePorDefecto | setter | no final | Método encargado de colocar el valor al atributo clientePorDefecto | valorClientePorDefecto | boolean/Boolean | - | Por valor | no final | Indica si la compra debe asociarse al cliente no registrado cuando el comprador no desea ser registrado en el sistema. | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarCliente | no static | no final | Crea el registro base del cliente asignando un ID universal y definiendo si es el cliente por defecto | datos | Otro | Cliente | Por valor | no final | Contiene la información requerida para registrar el cliente | Otro | Cliente | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosClientes | no static | no final | Permite consultar la información de todos los clientes base registrados en la base de datos | No aplica |  |  |  |  |  | Otro | List&lt;Cliente&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la lista de clientes |
| public | consultarClientesPorFiltro | no static | no final | Permite consultar los clientes que cumplen con los criterios de búsqueda enviados (id, clientePorDefecto) | filtro | Otro | Cliente | Por valor | no final | Contiene los parámetros o criterios de consulta enviados para filtrar la búsqueda | Otro | List&lt;Cliente&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si los parámetros de filtro de consulta son inválidos |
| public | eliminarCliente | no static | no final | Permite eliminar un cliente sin eliminar su historial de compras y devoluciones, solo si el cliente lo desea | id | Otro | UUID | Por valor | no final | Contiene el identificador único del cliente que se desea inhabilitar o eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando al usuario que el objeto de dominio está presente dentro de otro objeto |

[↑ Volver al índice](#clases)

---

## Marca

**Descripción:** Representa al fabricante de los accesorios y repuestos que comercializa el negocio.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | Producto |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la marca |
| private | nombre | String | - | no final | no static | - | Nombre del fabricante de los productos |
| private | esActivo | boolean/Boolean | - | no final | no static | No | Variable booleana que define si una marca específica sigue siendo usada en la empresa |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Marca | Defecto | Constructor por defecto que crea una instancia de Marca sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Marca | Parametrizado | Constructor parametrizado que crea una instancia de Marca inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la marca | No aplica |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre de la marca del producto |  |
|  |  |  |  | esActivo | boolean/Boolean | - | Por valor | no final | Variable booleana que define si una marca específica sigue siendo usada en la empresa |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la marca | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre del fabricante de los productos | void | - | No aplica |
| public | getEsActivo | getter | no final | Método encargado de obtener el valor del atributo esActivo | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setEsActivo | setter | no final | Método encargado de colocar el valor al atributo esActivo | valorEsActivo | boolean/Boolean | - | Por valor | no final | Variable booleana que define si una marca específica sigue siendo usada en la empresa | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarMarca | no static | no final | Permite ingresar una nueva marca en el catálogo general del sistema | datos | Otro | Marca | Por valor | no final | Contiene la información requerida para registrar la marca | Otro | Marca | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una marca con ese nombre |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasMarcas | no static | no final | Permite consultar la información detallada de las marcas registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Marca&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar el catálogo |
| public | consultarMarcasPorFiltro | no static | no final | Permite buscar, listar y filtrar el catálogo de marcas por nombre, identificador ID o estado | filtro | Otro | Marca | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Marca&gt; | Informar con un mensaje de error si los parámetros de filtro de consulta son inválidos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |

[↑ Volver al índice](#clases)

---

## Motivo

**Descripción:** Representa la razón por la que un cliente solicita devolver un producto.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | Devolucion |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del motivo |
| private | nombre | String | - | no final | no static | - | Nombre del motivo de devolución |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Motivo | Defecto | Constructor por defecto que crea una instancia de Motivo sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Motivo | Parametrizado | Constructor parametrizado que crea una instancia de Motivo inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del motivo | No aplica |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre del motivo de devolución |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del motivo | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre del motivo de devolución | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | consultarTodosMotivos | no static | no final | Permite consultar la información detallada de los motivos registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Motivo&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarMotivosPorFiltro | no static | no final | Permite buscar, listar y filtrar los motivos según los criterios de búsqueda enviados | filtro | Otro | Motivo | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Motivo&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## TipoDocumento

**Descripción:** Representa el tipo de documento de identidad de una persona

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | Persona |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del tipo de documento |
| private | tipo | String | - | no final | no static | - | Representa el nombre del tipo de documento de identidad de una persona |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | TipoDocumento | Defecto | Constructor por defecto que crea una instancia de TipoDocumento sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | TipoDocumento | Parametrizado | Constructor parametrizado que crea una instancia de TipoDocumento inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del tipo de documento | No aplica |
|  |  |  |  | tipo | String | - | Por valor | no final | Representa el nombre del tipo de documento de identidad de una persona |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del tipo de documento | void | - | No aplica |
| public | getTipo | getter | no final | Método encargado de obtener el valor del atributo tipo | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setTipo | setter | no final | Método encargado de colocar el valor al atributo tipo | valorTipo | String | - | Por valor | no final | Representa el nombre del tipo de documento de identidad de una persona | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | consultarTodosTiposDocumento | no static | no final | Permite buscar y visualizar todos los tipos de documento registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;TipoDocumento&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la lista de tipos de documento |
| public | consultarDocumentosPorFiltro | no static | no final | Permite buscar, listar y filtrar los tipos de documento según los criterios de búsqueda enviados | filtro | Otro | TipoDocumento | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;TipoDocumento&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |

[↑ Volver al índice](#clases)

---

## Categoria

**Descripción:** Representa la clasificación a la que pertenece un producto dentro del catálogo.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Categoria |
| Es usada por | Asociación | Producto |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la categoría |
| private | nombre | String | - | no final | no static | - | Nombre de la clasificación de productos |
| private | categoriaPadre | Otro | Categoria | no final | no static | Vacio | Identifica la categoría principal o superior a la que pertenece la clasificación correspondiente |
| private | nivel | int/Integer | - | no final | no static | 1 | Indica el nivel de profundidad jerárquica de la categoría dentro de la estructura del catálogo |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Categoria | Defecto | Constructor por defecto que crea una instancia de Categoria sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Categoria | Parametrizado | Constructor parametrizado que crea una instancia de Categoria inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la categoría | No aplica |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre de la clasificación de productos |  |
|  |  |  |  | categoriaPadre | Otro | Categoria | Por valor | no final | Identifica la categoría principal o superior a la que pertenece la clasificación correspondiente |  |
|  |  |  |  | nivel | int/Integer | - | Por valor | no final | Indica el nivel de profundidad jerárquica de la categoría dentro de la estructura del catálogo |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la categoría | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre de la clasificación de productos | void | - | No aplica |
| public | getCategoriaPadre | getter | no final | Método encargado de obtener el valor del atributo categoriaPadre | No aplica |  |  |  |  |  | Otro | Categoria | No aplica |
| public | setCategoriaPadre | setter | no final | Método encargado de colocar el valor al atributo categoriaPadre | valorCategoriaPadre | Otro | Categoria | Por valor | no final | Identifica la categoría principal o superior a la que pertenece la clasificación correspondiente | void | - | No aplica |
| public | getNivel | getter | no final | Método encargado de obtener el valor del atributo nivel | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setNivel | setter | no final | Método encargado de colocar el valor al atributo nivel | valorNivel | int/Integer | - | Por valor | no final | Indica el nivel de profundidad jerárquica de la categoría dentro de la estructura del catálogo | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarCategoria | no static | no final | Permite registrar una nueva categoría en el sistema | datos | Otro | Categoria | Por valor | no final | Contiene la información requerida para registrar la categoría | Otro | Categoria | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una categoría con ese mismo Nombre |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasCategorias | no static | no final | Permite consultar la información detallada de las categorías registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Categoria&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarCategoriasPorFiltro | no static | no final | Permite buscar, listar y filtrar las categorías según los criterios de búsqueda enviados | filtro | Otro | Categoria | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Categoria&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarCategoria | no static | no final | Permite actualizar la información de una categoría existente | datos | Otro | Categoria | Por valor | no final | Tiene el identificador único de la categoría a modificar y la nueva información | Otro | Categoria | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que la categoría no existe o no puede ser modificada |
| public | eliminarCategoria | no static | no final | Permite eliminar una categoría si no posee ningún objeto de dominio dentro de ella | id | Otro | UUID | Por valor | no final | Contiene el identificador único de la categoría que se desea eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando al usuario que un producto o categoría está presente dentro de la misma |

[↑ Volver al índice](#clases)

---

## Prefijo

**Descripción:** Representa el código de marcado telefónico asociado a un país para el registro de números de contacto

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Es usada por | Asociación | Persona |
| Es usada por | Asociación | ClienteRegistradoJ |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del Prefijo |
| private | codigo | String | - | no final | no static | - | Representa el código indicativo internacional de marcado telefónico |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Prefijo | Defecto | Constructor por defecto que crea una instancia de Prefijo sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Prefijo | Parametrizado | Constructor parametrizado que crea una instancia de Prefijo inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del Prefijo | No aplica |
|  |  |  |  | codigo | String | - | Por valor | no final | Representa el código indicativo internacional de marcado telefónico |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del Prefijo | void | - | No aplica |
| public | getCodigo | getter | no final | Método encargado de obtener el valor del atributo codigo | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setCodigo | setter | no final | Método encargado de colocar el valor al atributo codigo | valorCodigo | String | - | Por valor | no final | Representa el código indicativo internacional de marcado telefónico | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | consultarPrefijosPorFiltro | no static | no final | Permite consultar la información detallada de los prefijos registrados en el sistema | filtro | Otro | Prefijo | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Prefijo&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |

[↑ Volver al índice](#clases)

---

## Persona

**Descripción:** Representa a un individuo en el sistema con sus datos generales de identificación para registrarse en el sistema

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | TipoDocumento |
| Necesita de | Asociación | Prefijo |
| Es usada por | Asociación | ClienteRegistradoN |
| Es usada por | Asociación | Empleado |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la persona |
| private | tipoDocumento | Otro | TipoDocumento | no final | no static | - | Representa el tipo de documento de identidad de la persona |
| private | prefijo | Otro | Prefijo | no final | no static | - | Representa el código indicativo internacional de marcado telefónico asociado al teléfono de la persona |
| private | numeroDocumento | String | - | no final | no static | - | Representa el número del documento de identidad de la persona |
| private | telefono | String | - | no final | no static | - | Número de contacto de la persona |
| private | nombre | String | - | no final | no static | - | Representa el nombre de la persona |
| private | apellido | String | - | no final | no static | - | Representa el apellido de la persona |
| private | correo | String | - | no final | no static | - | Correo electrónico de las personas |
| private | telefonoConfirmado | boolean/Boolean | - | no final | no static | No | Variable booleana que define si el teléfono de la persona está confirmado o no |
| private | correoConfirmado | boolean/Boolean | - | no final | no static | No | Variable booleana que define si el correo electrónico de la persona está confirmado o no |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Persona | Defecto | Constructor por defecto que crea una instancia de Persona sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Persona | Parametrizado | Constructor parametrizado que crea una instancia de Persona inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la persona | No aplica |
|  |  |  |  | tipoDocumento | Otro | TipoDocumento | Por valor | no final | Representa el tipo de documento de identidad de la persona |  |
|  |  |  |  | prefijo | Otro | Prefijo | Por valor | no final | Representa el código indicativo internacional de marcado telefónico asociado al teléfono de la persona |  |
|  |  |  |  | numeroDocumento | String | - | Por valor | no final | Representa el número del documento de identidad de la persona |  |
|  |  |  |  | telefono | String | - | Por valor | no final | Número de contacto de la persona |  |
|  |  |  |  | nombre | String | - | Por valor | no final | Representa el nombre de la persona |  |
|  |  |  |  | apellido | String | - | Por valor | no final | Representa el apellido de la persona |  |
|  |  |  |  | correo | String | - | Por valor | no final | Correo electrónico de las personas |  |
|  |  |  |  | telefonoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el teléfono de la persona está confirmado o no |  |
|  |  |  |  | correoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el correo electrónico de la persona está confirmado o no |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la persona | void | - | No aplica |
| public | getTipoDocumento | getter | no final | Método encargado de obtener el valor del atributo tipoDocumento | No aplica |  |  |  |  |  | Otro | TipoDocumento | No aplica |
| public | setTipoDocumento | setter | no final | Método encargado de colocar el valor al atributo tipoDocumento | valorTipoDocumento | Otro | TipoDocumento | Por valor | no final | Representa el tipo de documento de identidad de la persona | void | - | No aplica |
| public | getPrefijo | getter | no final | Método encargado de obtener el valor del atributo prefijo | No aplica |  |  |  |  |  | Otro | Prefijo | No aplica |
| public | setPrefijo | setter | no final | Método encargado de colocar el valor al atributo prefijo | valorPrefijo | Otro | Prefijo | Por valor | no final | Representa el código indicativo internacional de marcado telefónico asociado al teléfono de la persona | void | - | No aplica |
| public | getNumeroDocumento | getter | no final | Método encargado de obtener el valor del atributo numeroDocumento | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNumeroDocumento | setter | no final | Método encargado de colocar el valor al atributo numeroDocumento | valorNumeroDocumento | String | - | Por valor | no final | Representa el número del documento de identidad de la persona | void | - | No aplica |
| public | getTelefono | getter | no final | Método encargado de obtener el valor del atributo telefono | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setTelefono | setter | no final | Método encargado de colocar el valor al atributo telefono | valorTelefono | String | - | Por valor | no final | Número de contacto de la persona | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Representa el nombre de la persona | void | - | No aplica |
| public | getApellido | getter | no final | Método encargado de obtener el valor del atributo apellido | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setApellido | setter | no final | Método encargado de colocar el valor al atributo apellido | valorApellido | String | - | Por valor | no final | Representa el apellido de la persona | void | - | No aplica |
| public | getCorreo | getter | no final | Método encargado de obtener el valor del atributo correo | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setCorreo | setter | no final | Método encargado de colocar el valor al atributo correo | valorCorreo | String | - | Por valor | no final | Correo electrónico de las personas | void | - | No aplica |
| public | getTelefonoConfirmado | getter | no final | Método encargado de obtener el valor del atributo telefonoConfirmado | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setTelefonoConfirmado | setter | no final | Método encargado de colocar el valor al atributo telefonoConfirmado | valorTelefonoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el teléfono de la persona está confirmado o no | void | - | No aplica |
| public | getCorreoConfirmado | getter | no final | Método encargado de obtener el valor del atributo correoConfirmado | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setCorreoConfirmado | setter | no final | Método encargado de colocar el valor al atributo correoConfirmado | valorCorreoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el correo electrónico de la persona está confirmado o no | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarPersona | no static | no final | Permite registrar una nueva persona en el sistema | datos | Otro | Persona | Por valor | no final | Contiene la información requerida para registrar la persona correspondiente | Otro | Persona | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una persona con ese mismo Documento |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una persona con ese mismo Telefono |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una persona con ese mismo Correo |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el NIT no está disponible para registrar persona natural |
| public | consultarPersonasPorFiltro | no static | no final | Permite buscar, listar y filtrar las personas según los criterios de búsqueda enviados | filtro | Otro | Persona | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Persona&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | modificarPersona | no static | no final | Permite actualizar la información de una persona existente | id | Otro | UUID | Por valor | no final | Tiene el identificador único de una persona a modificar | Otro | Persona | Generar una excepción indicando que ya existe una persona con ese mismo Documento |
|  |  |  |  |  | datos | Otro | Persona | Por valor | no final | Contiene la nueva información de la persona a modificar |  |  | Generar una excepción indicando que ya existe una persona con ese mismo Telefono |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una persona con ese mismo Correo |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | eliminarPersona | no static | no final | Permite eliminar una persona eliminando la trazabilidad de su historial | id | Otro | UUID | Por valor | no final | Contiene el identificador único de la persona que se desea eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando al usuario que el objeto de dominio está presente dentro de otro objeto |

[↑ Volver al índice](#clases)

---

## Producto

**Descripción:** Representa un artículo del catálogo general del negocio, independiente de la sede en la que se encuentre.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Categoria |
| Necesita de | Asociación | Marca |
| Es usada por | Asociación | ProductoSede |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del producto |
| private | marca | Otro | Marca | no final | no static | - | Marca a la que pertenece el producto |
| private | categoria | Otro | Categoria | no final | no static | - | Categoría a la que pertenece el producto |
| private | modelo | String | - | no final | no static | - | Modelo o referencia única del producto |
| private | nombre | String | - | no final | no static | - | Nombre del accesorio dentro del catálogo general |
| private | descripcion | String | - | no final | no static | - | Descripción general del accesorio |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Producto | Defecto | Constructor por defecto que crea una instancia de Producto sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Producto | Parametrizado | Constructor parametrizado que crea una instancia de Producto inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del producto | No aplica |
|  |  |  |  | marca | Otro | Marca | Por valor | no final | Marca a la que pertenece el producto |  |
|  |  |  |  | categoria | Otro | Categoria | Por valor | no final | Categoría a la que pertenece el producto |  |
|  |  |  |  | modelo | String | - | Por valor | no final | Modelo o referencia única del producto |  |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre del accesorio dentro del catálogo general |  |
|  |  |  |  | descripcion | String | - | Por valor | no final | Descripción general del accesorio |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del producto | void | - | No aplica |
| public | getMarca | getter | no final | Método encargado de obtener el valor del atributo marca | No aplica |  |  |  |  |  | Otro | Marca | No aplica |
| public | setMarca | setter | no final | Método encargado de colocar el valor al atributo marca | valorMarca | Otro | Marca | Por valor | no final | Marca a la que pertenece el producto | void | - | No aplica |
| public | getCategoria | getter | no final | Método encargado de obtener el valor del atributo categoria | No aplica |  |  |  |  |  | Otro | Categoria | No aplica |
| public | setCategoria | setter | no final | Método encargado de colocar el valor al atributo categoria | valorCategoria | Otro | Categoria | Por valor | no final | Categoría a la que pertenece el producto | void | - | No aplica |
| public | getModelo | getter | no final | Método encargado de obtener el valor del atributo modelo | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setModelo | setter | no final | Método encargado de colocar el valor al atributo modelo | valorModelo | String | - | Por valor | no final | Modelo o referencia única del producto | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre del accesorio dentro del catálogo general | void | - | No aplica |
| public | getDescripcion | getter | no final | Método encargado de obtener el valor del atributo descripcion | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setDescripcion | setter | no final | Método encargado de colocar el valor al atributo descripcion | valorDescripcion | String | - | Por valor | no final | Descripción general del accesorio | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarProducto | no static | no final | Permite registrar un nuevo producto en el sistema | datos | Otro | Producto | Por valor | no final | Contiene la información requerida para registrar el producto | Otro | Producto | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un producto con ese mismo Modelo |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosProductos | no static | no final | Permite consultar la información detallada de los productos registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Producto&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarProductosPorFiltro | no static | no final | Permite buscar, listar y filtrar los productos según los criterios de búsqueda enviados | filtro | Otro | Producto | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Producto&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarProducto | no static | no final | Permite actualizar la información de un producto existente | datos | Otro | Producto | Por valor | no final | Tiene el identificador único del producto a modificar y la nueva información | Otro | Producto | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el producto no existe o no puede ser modificado |

[↑ Volver al índice](#clases)

---

## Departamento

**Descripción:** Representa el departamento o división administrativa al que pertenece una ciudad dentro de un país.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Pais |
| Es usada por | Asociación | Ciudad |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del departamento |
| private | pais | Otro | Pais | no final | no static | - | País al que pertenece el departamento |
| private | nombre | String | - | no final | no static | - | Nombre oficial del departamento o división administrativa |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Departamento | Defecto | Constructor por defecto que crea una instancia de Departamento sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Departamento | Parametrizado | Constructor parametrizado que crea una instancia de Departamento inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del departamento | No aplica |
|  |  |  |  | pais | Otro | Pais | Por valor | no final | País al que pertenece el departamento |  |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre oficial del departamento o división administrativa |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del departamento | void | - | No aplica |
| public | getPais | getter | no final | Método encargado de obtener el valor del atributo pais | No aplica |  |  |  |  |  | Otro | Pais | No aplica |
| public | setPais | setter | no final | Método encargado de colocar el valor al atributo pais | valorPais | Otro | Pais | Por valor | no final | País al que pertenece el departamento | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre oficial del departamento o división administrativa | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | consultarTodosDepartamentos | no static | no final | Permite consultar la información detallada de los departamentos registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Departamento&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarDepartamentosPorFiltro | no static | no final | Permite buscar, listar y filtrar los departamentos según los criterios de búsqueda enviados | filtro | Otro | Departamento | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Departamento&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## ClienteRegistrado

**Descripción:** Representa al cliente cuyos datos de identificación y contacto han sido registrados en el sistema

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Cliente |
| Es usada por | Asociación | ClienteRegistradoN |
| Es usada por | Asociación | ClienteRegistradoJ |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del cliente registrado |
| private | cliente | Otro | Cliente | no final | no static | - | Referencia al cliente asociado al cliente registrado |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | ClienteRegistrado | Defecto | Constructor por defecto que crea una instancia de ClienteRegistrado sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | ClienteRegistrado | Parametrizado | Constructor parametrizado que crea una instancia de ClienteRegistrado inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del cliente registrado | No aplica |
|  |  |  |  | cliente | Otro | Cliente | Por valor | no final | Referencia al cliente asociado al cliente registrado |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del cliente registrado | void | - | No aplica |
| public | getCliente | getter | no final | Método encargado de obtener el valor del atributo cliente | No aplica |  |  |  |  |  | Otro | Cliente | No aplica |
| public | setCliente | setter | no final | Método encargado de colocar el valor al atributo cliente | valorCliente | Otro | Cliente | Por valor | no final | Referencia al cliente asociado al cliente registrado | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarClienteRegistrado | no static | no final | Permite registrar un nuevo cliente registrado en el sistema | datos | Otro | ClienteRegistrado | Por valor | no final | Contiene la información requerida para registrar el cliente registrado | Otro | ClienteRegistrado | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ese cliente ya se ha registrado en algún momento en el sistema |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosClientesRegistrados | no static | no final | Permite buscar y visualizar todos los clientes registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;ClienteRegistrado&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la lista de clientes registrados |
| public | consultarClientesRegistradosPorFiltro | no static | no final | Permite buscar, listar y filtrar los clientes registrados según los criterios de búsqueda enviados | filtro | Otro | ClienteRegistrado | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;ClienteRegistrado&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | eliminarClienteRegistrado | no static | no final | Permite eliminar un cliente eliminando todo su historial de compras y de devoluciones, solo si el cliente registrado lo desea | id | Otro | UUID | Por valor | no final | Contiene el identificador único del cliente que se desea eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando al usuario que el cliente registrado está siendo usado por otros tipos de clientes registrados |

[↑ Volver al índice](#clases)

---

## ClienteNoRegistrado

**Descripción:** Representa a la persona que realiza una compra sin contar con un registro previo en el sistema

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Cliente |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del cliente no registrado |
| private | cliente | Otro | Cliente | no final | no static | - | Cliente base al que corresponde el cliente no registrado |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | ClienteNoRegistrado | Defecto | Constructor por defecto que crea una instancia de ClienteNoRegistrado sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | ClienteNoRegistrado | Parametrizado | Constructor parametrizado que crea una instancia de ClienteNoRegistrado inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del cliente no registrado | No aplica |
|  |  |  |  | cliente | Otro | Cliente | Por valor | no final | Cliente base al que corresponde el cliente no registrado |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del cliente no registrado | void | - | No aplica |
| public | getCliente | getter | no final | Método encargado de obtener el valor del atributo cliente | No aplica |  |  |  |  |  | Otro | Cliente | No aplica |
| public | setCliente | setter | no final | Método encargado de colocar el valor al atributo cliente | valorCliente | Otro | Cliente | Por valor | no final | Cliente base al que corresponde el cliente no registrado | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarClienteNoRegistrado | no static | no final | Permite registrar un nuevo cliente no registrado en el sistema | datos | Otro | ClienteNoRegistrado | Por valor | no final | Contiene la información requerida para registrar el cliente no registrado | Otro | ClienteNoRegistrado | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosClientesNoRegistrados | no static | no final | Permite consultar la información detallada de los clientes no registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;ClienteNoRegistrado&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarClientesNoRegistradosPorFiltro | no static | no final | Permite buscar, listar y filtrar los clientes no registrados según los criterios de búsqueda enviados | filtro | Otro | ClienteNoRegistrado | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;ClienteNoRegistrado&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## ClienteRegistradoN

**Descripción:** Representa al cliente registrado natural en el sistema con sus datos básicos de identificación y contacto

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | ClienteRegistrado |
| Necesita de | Asociación | Persona |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del cliente registrado natural |
| private | clienteRegistrado | Otro | ClienteRegistrado | no final | no static | - | Referencia al cliente registrado asociado al cliente registrado natural |
| private | persona | Otro | Persona | no final | no static | - | Referencia a la persona asociada al cliente registrado natural |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | ClienteRegistradoN | Defecto | Constructor por defecto que crea una instancia de ClienteRegistradoN sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | ClienteRegistradoN | Parametrizado | Constructor parametrizado que crea una instancia de ClienteRegistradoN inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del cliente registrado natural | No aplica |
|  |  |  |  | clienteRegistrado | Otro | ClienteRegistrado | Por valor | no final | Referencia al cliente registrado asociado al cliente registrado natural |  |
|  |  |  |  | persona | Otro | Persona | Por valor | no final | Referencia a la persona asociada al cliente registrado natural |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del cliente registrado natural | void | - | No aplica |
| public | getClienteRegistrado | getter | no final | Método encargado de obtener el valor del atributo clienteRegistrado | No aplica |  |  |  |  |  | Otro | ClienteRegistrado | No aplica |
| public | setClienteRegistrado | setter | no final | Método encargado de colocar el valor al atributo clienteRegistrado | valorClienteRegistrado | Otro | ClienteRegistrado | Por valor | no final | Referencia al cliente registrado asociado al cliente registrado natural | void | - | No aplica |
| public | getPersona | getter | no final | Método encargado de obtener el valor del atributo persona | No aplica |  |  |  |  |  | Otro | Persona | No aplica |
| public | setPersona | setter | no final | Método encargado de colocar el valor al atributo persona | valorPersona | Otro | Persona | Por valor | no final | Referencia a la persona asociada al cliente registrado natural | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarClienteRegistradoNatural | no static | no final | Permite registrar un nuevo cliente registrado natural en el sistema | datos | Otro | ClienteRegistradoN | Por valor | no final | Contiene la información requerida para registrar el cliente registrado natural correspondiente | Otro | ClienteRegistradoN | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado natural o jurídico asociado a ese mismo ClienteRegistrado |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que la persona ya se encuentra asociada a otro cliente registrado natural o empleado |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarClientesRegistradosNaturalesPorFiltro | no static | no final | Permite buscar, listar y filtrar los clientes registrados naturales según los criterios de búsqueda enviados | filtro | Otro | ClienteRegistradoN | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;ClienteRegistradoN&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | eliminarClienteRegistradoNatural | no static | no final | Permite eliminar un cliente registrado natural eliminando la trazabilidad de su historial, solo si el cliente lo desea | id | Otro | UUID | Por valor | no final | Contiene el identificador único del cliente registrado natural que se desea eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el cliente se encuentra realizando una transacción importante en el momento, por lo que es imposible eliminarlo instantáneamente |

[↑ Volver al índice](#clases)

---

## ClienteRegistradoJ

**Descripción:** Representa al cliente registrado Jurídico en el sistema con sus datos básicos de identificación y contacto

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | ClienteRegistrado |
| Necesita de | Asociación | Prefijo |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del cliente registrado jurídico |
| private | clienteRegistrado | Otro | ClienteRegistrado | no final | no static | - | Representa al cliente registrado asociado al cliente registrado jurídico |
| private | prefijo | Otro | Prefijo | no final | no static | - | Representa el código indicativo internacional de marcado telefónico del cliente registrado jurídico |
| private | telefono | String | - | no final | no static | - | Número de contacto de un cliente registrado jurídico |
| private | nit | String | - | no final | no static | - | Representa el número del documento de un cliente registrado jurídico |
| private | razonSocial | String | - | no final | no static | - | Representa el nombre de un cliente registrado jurídico |
| private | correo | String | - | no final | no static | - | Correo electrónico de un cliente registrado jurídico |
| private | correoConfirmado | boolean/Boolean | - | no final | no static | No | Variable booleana que define si el correo de un cliente registrado jurídico está confirmado o no |
| private | telefonoConfirmado | boolean/Boolean | - | no final | no static | No | Variable booleana que define si el teléfono de un cliente registrado jurídico está confirmado o no |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | ClienteRegistradoJ | Defecto | Constructor por defecto que crea una instancia de ClienteRegistradoJ sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | ClienteRegistradoJ | Parametrizado | Constructor parametrizado que crea una instancia de ClienteRegistradoJ inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del cliente registrado jurídico | No aplica |
|  |  |  |  | clienteRegistrado | Otro | ClienteRegistrado | Por valor | no final | Representa al cliente registrado asociado al cliente registrado jurídico |  |
|  |  |  |  | prefijo | Otro | Prefijo | Por valor | no final | Representa el código indicativo internacional de marcado telefónico del cliente registrado jurídico |  |
|  |  |  |  | telefono | String | - | Por valor | no final | Número de contacto de un cliente registrado jurídico |  |
|  |  |  |  | nit | String | - | Por valor | no final | Representa el número del documento de un cliente registrado jurídico |  |
|  |  |  |  | razonSocial | String | - | Por valor | no final | Representa el nombre de un cliente registrado jurídico |  |
|  |  |  |  | correo | String | - | Por valor | no final | Correo electrónico de un cliente registrado jurídico |  |
|  |  |  |  | correoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el correo de un cliente registrado jurídico está confirmado o no |  |
|  |  |  |  | telefonoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el teléfono de un cliente registrado jurídico está confirmado o no |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del cliente registrado jurídico | void | - | No aplica |
| public | getClienteRegistrado | getter | no final | Método encargado de obtener el valor del atributo clienteRegistrado | No aplica |  |  |  |  |  | Otro | ClienteRegistrado | No aplica |
| public | setClienteRegistrado | setter | no final | Método encargado de colocar el valor al atributo clienteRegistrado | valorClienteRegistrado | Otro | ClienteRegistrado | Por valor | no final | Representa al cliente registrado asociado al cliente registrado jurídico | void | - | No aplica |
| public | getPrefijo | getter | no final | Método encargado de obtener el valor del atributo prefijo | No aplica |  |  |  |  |  | Otro | Prefijo | No aplica |
| public | setPrefijo | setter | no final | Método encargado de colocar el valor al atributo prefijo | valorPrefijo | Otro | Prefijo | Por valor | no final | Representa el código indicativo internacional de marcado telefónico del cliente registrado jurídico | void | - | No aplica |
| public | getTelefono | getter | no final | Método encargado de obtener el valor del atributo telefono | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setTelefono | setter | no final | Método encargado de colocar el valor al atributo telefono | valorTelefono | String | - | Por valor | no final | Número de contacto de un cliente registrado jurídico | void | - | No aplica |
| public | getNit | getter | no final | Método encargado de obtener el valor del atributo nit | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNit | setter | no final | Método encargado de colocar el valor al atributo nit | valorNit | String | - | Por valor | no final | Representa el número del documento de un cliente registrado jurídico | void | - | No aplica |
| public | getRazonSocial | getter | no final | Método encargado de obtener el valor del atributo razonSocial | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setRazonSocial | setter | no final | Método encargado de colocar el valor al atributo razonSocial | valorRazonSocial | String | - | Por valor | no final | Representa el nombre de un cliente registrado jurídico | void | - | No aplica |
| public | getCorreo | getter | no final | Método encargado de obtener el valor del atributo correo | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setCorreo | setter | no final | Método encargado de colocar el valor al atributo correo | valorCorreo | String | - | Por valor | no final | Correo electrónico de un cliente registrado jurídico | void | - | No aplica |
| public | getCorreoConfirmado | getter | no final | Método encargado de obtener el valor del atributo correoConfirmado | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setCorreoConfirmado | setter | no final | Método encargado de colocar el valor al atributo correoConfirmado | valorCorreoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el correo de un cliente registrado jurídico está confirmado o no | void | - | No aplica |
| public | getTelefonoConfirmado | getter | no final | Método encargado de obtener el valor del atributo telefonoConfirmado | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setTelefonoConfirmado | setter | no final | Método encargado de colocar el valor al atributo telefonoConfirmado | valorTelefonoConfirmado | boolean/Boolean | - | Por valor | no final | Variable booleana que define si el teléfono de un cliente registrado jurídico está confirmado o no | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarClienteRegistradoJuridico | no static | no final | Permite registrar un nuevo cliente registrado jurídico en el sistema | datos | Otro | ClienteRegistradoJ | Por valor | no final | Contiene la información requerida para registrar el cliente registrado jurídico correspondiente | Otro | ClienteRegistradoJ | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado con ese mismo NIT |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Telefono |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Correo |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado con esa misma Razon social |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado natural o jurídico asociado a ese mismo ClienteRegistrado |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarClientesRegistradosJuridicosPorFiltro | no static | no final | Permite buscar, listar y filtrar los clientes registrados jurídicos según los criterios de búsqueda enviados | filtro | Otro | ClienteRegistradoJ | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;ClienteRegistradoJ&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | modificarClienteRegistradoJuridico | no static | no final | Permite actualizar la información de un cliente registrado jurídico existente | id | Otro | UUID | Por valor | no final | Tiene el identificador único del cliente registrado jurídico a modificar | Otro | ClienteRegistradoJ | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Telefono |
|  |  |  |  |  | datos | Otro | ClienteRegistradoJ | Por valor | no final | Contiene la nueva información del cliente registrado jurídico |  |  | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Correo |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un cliente registrado con esa misma Razon social |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el cliente registrado no existe o no puede ser modificado |
| public | eliminarClienteRegistradoJuridico | no static | no final | Permite eliminar un cliente registrado jurídico eliminando la trazabilidad de su historial | id | Otro | UUID | Por valor | no final | Contiene el identificador único del cliente registrado jurídico que se desea eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el cliente se encuentra realizando una transacción importante en el momento, por lo que es imposible eliminarlo instantáneamente |

[↑ Volver al índice](#clases)

---

## Ciudad

**Descripción:** Representa la ciudad o municipio donde se ubican las sedes del negocio y residen los clientes.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Departamento |
| Es usada por | Asociación | Sede |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la ciudad |
| private | departamento | Otro | Departamento | no final | no static | - | Departamento al que pertenece la ciudad |
| private | nombre | String | - | no final | no static | - | Nombre oficial de la ciudad o municipio |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Ciudad | Defecto | Constructor por defecto que crea una instancia de Ciudad sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Ciudad | Parametrizado | Constructor parametrizado que crea una instancia de Ciudad inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la ciudad | No aplica |
|  |  |  |  | departamento | Otro | Departamento | Por valor | no final | Departamento al que pertenece la ciudad |  |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre oficial de la ciudad o municipio |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la ciudad | void | - | No aplica |
| public | getDepartamento | getter | no final | Método encargado de obtener el valor del atributo departamento | No aplica |  |  |  |  |  | Otro | Departamento | No aplica |
| public | setDepartamento | setter | no final | Método encargado de colocar el valor al atributo departamento | valorDepartamento | Otro | Departamento | Por valor | no final | Departamento al que pertenece la ciudad | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre oficial de la ciudad o municipio | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | consultarTodasCiudades | no static | no final | Permite consultar la información detallada de las ciudades registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Ciudad&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarCiudadesPorFiltro | no static | no final | Permite buscar, listar y filtrar las ciudades según los criterios de búsqueda enviados | filtro | Otro | Ciudad | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Ciudad&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## Sede

**Descripción:** Representa cada local físico del negocio, donde se atienden las compras y se almacena la mercancía.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Ciudad |
| Es usada por | Asociación | Empleado |
| Es usada por | Asociación | IngresoInventario |
| Es usada por | Asociación | ProductoSede |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la sede |
| private | ciudad | Otro | Ciudad | no final | no static | - | Ciudad en la que está ubicada la sede |
| private | nombre | String | - | no final | no static | - | Nombre con el que se identifica el local físico |
| private | nit | String | - | no final | no static | - | Número de NIT legal con el que se identifica la sede |
| private | direccion | String | - | no final | no static | - | Dirección física donde está ubicada la sede |
| private | esActiva | boolean/Boolean | - | no final | no static | Si | Variable booleana que define si una sede está funcionando actualmente o no |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Sede | Defecto | Constructor por defecto que crea una instancia de Sede sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Sede | Parametrizado | Constructor parametrizado que crea una instancia de Sede inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la sede | No aplica |
|  |  |  |  | ciudad | Otro | Ciudad | Por valor | no final | Ciudad en la que está ubicada la sede |  |
|  |  |  |  | nombre | String | - | Por valor | no final | Nombre con el que se identifica el local físico |  |
|  |  |  |  | nit | String | - | Por valor | no final | Número de NIT legal con el que se identifica la sede |  |
|  |  |  |  | direccion | String | - | Por valor | no final | Dirección física donde está ubicada la sede |  |
|  |  |  |  | esActiva | boolean/Boolean | - | Por valor | no final | Variable booleana que define si una sede está funcionando actualmente o no |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la sede | void | - | No aplica |
| public | getCiudad | getter | no final | Método encargado de obtener el valor del atributo ciudad | No aplica |  |  |  |  |  | Otro | Ciudad | No aplica |
| public | setCiudad | setter | no final | Método encargado de colocar el valor al atributo ciudad | valorCiudad | Otro | Ciudad | Por valor | no final | Ciudad en la que está ubicada la sede | void | - | No aplica |
| public | getNombre | getter | no final | Método encargado de obtener el valor del atributo nombre | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNombre | setter | no final | Método encargado de colocar el valor al atributo nombre | valorNombre | String | - | Por valor | no final | Nombre con el que se identifica el local físico | void | - | No aplica |
| public | getNit | getter | no final | Método encargado de obtener el valor del atributo nit | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setNit | setter | no final | Método encargado de colocar el valor al atributo nit | valorNit | String | - | Por valor | no final | Número de NIT legal con el que se identifica la sede | void | - | No aplica |
| public | getDireccion | getter | no final | Método encargado de obtener el valor del atributo direccion | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setDireccion | setter | no final | Método encargado de colocar el valor al atributo direccion | valorDireccion | String | - | Por valor | no final | Dirección física donde está ubicada la sede | void | - | No aplica |
| public | getEsActiva | getter | no final | Método encargado de obtener el valor del atributo esActiva | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setEsActiva | setter | no final | Método encargado de colocar el valor al atributo esActiva | valorEsActiva | boolean/Boolean | - | Por valor | no final | Variable booleana que define si una sede está funcionando actualmente o no | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarSede | no static | no final | Permite registrar una nueva sede en el sistema | datos | Otro | Sede | Por valor | no final | Contiene la información requerida para registrar la sede | Otro | Sede | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una sede con ese mismo Nombre |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una sede con ese mismo NIT |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una sede con esa misma Dirección |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una sede con ese mismo Telefono |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasSedes | no static | no final | Permite consultar la información detallada de las sedes registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Sede&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarSedesPorFiltro | no static | no final | Permite buscar, listar y filtrar las sedes según los criterios de búsqueda enviados | filtro | Otro | Sede | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Sede&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarSede | no static | no final | Permite actualizar la información de una sede existente | datos | Otro | Sede | Por valor | no final | Tiene el identificador único de la sede a modificar y la nueva información | Otro | Sede | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que la sede no existe o no puede ser modificada |

[↑ Volver al índice](#clases)

---

## IngresoInventario

**Descripción:** Representa la factura de la llegada de nueva mercancía a una sede por parte de un proveedor que la creó previamente.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Sede |
| Es usada por | Asociación | DetalleIngreso |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del ingreso de inventario |
| private | estado | String | - | no final | no static | Pendiente | Estado actual del ingreso de inventario (En proceso, Cancelado y Creado) |
| private | sede | Otro | Sede | no final | no static | - | Nombre de la sede que recibe la mercancía |
| private | fechaLlegada | Date | - | no final | no static | - | Fecha en que llega la mercancía a la sede |
| private | total | double/Double | - | no final | no static | - | Valor total de la mercancía ingresada |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | IngresoInventario | Defecto | Constructor por defecto que crea una instancia de IngresoInventario sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | IngresoInventario | Parametrizado | Constructor parametrizado que crea una instancia de IngresoInventario inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del ingreso de inventario | No aplica |
|  |  |  |  | estado | String | - | Por valor | no final | Estado actual del ingreso de inventario (En proceso, Cancelado y Creado) |  |
|  |  |  |  | sede | Otro | Sede | Por valor | no final | Nombre de la sede que recibe la mercancía |  |
|  |  |  |  | fechaLlegada | Date | - | Por valor | no final | Fecha en que llega la mercancía a la sede |  |
|  |  |  |  | total | double/Double | - | Por valor | no final | Valor total de la mercancía ingresada |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del ingreso de inventario | void | - | No aplica |
| public | getEstado | getter | no final | Método encargado de obtener el valor del atributo estado | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setEstado | setter | no final | Método encargado de colocar el valor al atributo estado | valorEstado | String | - | Por valor | no final | Estado actual del ingreso de inventario (En proceso, Cancelado y Creado) | void | - | No aplica |
| public | getSede | getter | no final | Método encargado de obtener el valor del atributo sede | No aplica |  |  |  |  |  | Otro | Sede | No aplica |
| public | setSede | setter | no final | Método encargado de colocar el valor al atributo sede | valorSede | Otro | Sede | Por valor | no final | Nombre de la sede que recibe la mercancía | void | - | No aplica |
| public | getFechaLlegada | getter | no final | Método encargado de obtener el valor del atributo fechaLlegada | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaLlegada | setter | no final | Método encargado de colocar el valor al atributo fechaLlegada | valorFechaLlegada | Date | - | Por valor | no final | Fecha en que llega la mercancía a la sede | void | - | No aplica |
| public | getTotal | getter | no final | Método encargado de obtener el valor del atributo total | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setTotal | setter | no final | Método encargado de colocar el valor al atributo total | valorTotal | double/Double | - | Por valor | no final | Valor total de la mercancía ingresada | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarIngresoInventario | no static | no final | Permite registrar un nuevo ingreso de inventario en el sistema | datos | Otro | IngresoInventario | Por valor | no final | Contiene la información requerida para registrar el ingreso de inventario | Otro | IngresoInventario | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un ingreso de inventario con ese mismo Proveedor |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosIngresosInventario | no static | no final | Permite consultar la información detallada de los ingresos de inventario registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;IngresoInventario&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarIngresosInventarioPorFiltro | no static | no final | Permite buscar, listar y filtrar los ingresos de inventario según los criterios de búsqueda enviados | filtro | Otro | IngresoInventario | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;IngresoInventario&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarIngresoInventario | no static | no final | Permite actualizar la información de un ingreso de inventario existente | datos | Otro | IngresoInventario | Por valor | no final | Tiene el identificador único del ingreso de inventario a modificar y la nueva información | Otro | IngresoInventario | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el ingreso de inventario no existe o no puede ser modificado |

[↑ Volver al índice](#clases)

---

## Empleado

**Descripción:** Representa al personal contratado que trabaja en una sede específica, es quien atiende las compras de los clientes.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Sede |
| Necesita de | Asociación | Persona |
| Es usada por | Asociación | Administrador |
| Es usada por | Asociación | Vendedor |
| Es usada por | Asociación | ProcesoCompra |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del empleado |
| private | sede | Otro | Sede | no final | no static | - | Referencia a la sede en la que trabaja el empleado |
| private | persona | Otro | Persona | no final | no static | - | Referencia a la persona asociada al empleado |
| private | esActivo | boolean/Boolean | - | no final | no static | Si | Indica si el empleado se encuentra activo en el negocio |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Empleado | Defecto | Constructor por defecto que crea una instancia de Empleado sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Empleado | Parametrizado | Constructor parametrizado que crea una instancia de Empleado inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del empleado | No aplica |
|  |  |  |  | sede | Otro | Sede | Por valor | no final | Referencia a la sede en la que trabaja el empleado |  |
|  |  |  |  | persona | Otro | Persona | Por valor | no final | Referencia a la persona asociada al empleado |  |
|  |  |  |  | esActivo | boolean/Boolean | - | Por valor | no final | Indica si el empleado se encuentra activo en el negocio |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del empleado | void | - | No aplica |
| public | getSede | getter | no final | Método encargado de obtener el valor del atributo sede | No aplica |  |  |  |  |  | Otro | Sede | No aplica |
| public | setSede | setter | no final | Método encargado de colocar el valor al atributo sede | valorSede | Otro | Sede | Por valor | no final | Referencia a la sede en la que trabaja el empleado | void | - | No aplica |
| public | getPersona | getter | no final | Método encargado de obtener el valor del atributo persona | No aplica |  |  |  |  |  | Otro | Persona | No aplica |
| public | setPersona | setter | no final | Método encargado de colocar el valor al atributo persona | valorPersona | Otro | Persona | Por valor | no final | Referencia a la persona asociada al empleado | void | - | No aplica |
| public | getEsActivo | getter | no final | Método encargado de obtener el valor del atributo esActivo | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setEsActivo | setter | no final | Método encargado de colocar el valor al atributo esActivo | valorEsActivo | boolean/Boolean | - | Por valor | no final | Indica si el empleado se encuentra activo en el negocio | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarEmpleado | no static | no final | Permite registrar un nuevo empleado en el sistema | datos | Otro | Empleado | Por valor | no final | Contiene la información requerida para registrar el empleado | Otro | Empleado | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un empleado con esa misma persona asociada |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que la sede no está activa en el momento |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosEmpleados | no static | no final | Permite buscar y visualizar todos los empleados registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Empleado&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la lista de empleados |
| public | consultarEmpleadosPorFiltro | no static | no final | Permite buscar, listar y filtrar los empleados según los criterios de búsqueda enviados | filtro | Otro | Empleado | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Empleado&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | modificarEmpleado | no static | no final | Permite actualizar la información de un empleado existente | id | Otro | UUID | Por valor | no final | Tiene el identificador único del empleado a modificar | Otro | Empleado | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  | datos | Otro | Empleado | Por valor | no final | Contiene la nueva información del empleado |  |  | Generar una excepción indicando que el empleado no existe o no puede ser modificado |

[↑ Volver al índice](#clases)

---

## ProductoSede

**Descripción:** Representa el inventario real de un producto en una sede determinada.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Producto |
| Necesita de | Asociación | Sede |
| Es usada por | Asociación | DetalleCompra |
| Es usada por | Asociación | DetalleIngreso |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del inventario físico producto-sede |
| private | producto | Otro | Producto | no final | no static | - | Producto del catálogo general de la empresa |
| private | sede | Otro | Sede | no final | no static | - | Nombre de la sede donde se encuentra el inventario |
| private | precio | double/Double | - | no final | no static | - | Precio de venta local del producto en la sede |
| private | tieneOferta | boolean/Boolean | - | no final | no static | - | Variable booleana que define si un producto específico en una sede tiene oferta actualmente o no |
| private | oferta | int/Integer | - | no final | no static | 0 | Oferta que se le aplica al producto correspondiente, definida por el administrador |
| private | precioTrasOferta | double/Double | - | no final | no static | - | Valor calculado al aplicar el descuento correspondiente al precio del producto en cuestión |
| private | stock | int/Integer | - | no final | no static | - | Cantidad de unidades disponibles del producto en la sede |
| private | stockGarantia | int/Integer | - | no final | no static | - | Cantidad de unidades que necesitan cambio del producto específico en la sede |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | ProductoSede | Defecto | Constructor por defecto que crea una instancia de ProductoSede sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | ProductoSede | Parametrizado | Constructor parametrizado que crea una instancia de ProductoSede inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del inventario físico producto-sede | No aplica |
|  |  |  |  | producto | Otro | Producto | Por valor | no final | Producto del catálogo general de la empresa |  |
|  |  |  |  | sede | Otro | Sede | Por valor | no final | Nombre de la sede donde se encuentra el inventario |  |
|  |  |  |  | precio | double/Double | - | Por valor | no final | Precio de venta local del producto en la sede |  |
|  |  |  |  | tieneOferta | boolean/Boolean | - | Por valor | no final | Variable booleana que define si un producto específico en una sede tiene oferta actualmente o no |  |
|  |  |  |  | oferta | int/Integer | - | Por valor | no final | Oferta que se le aplica al producto correspondiente, definida por el administrador |  |
|  |  |  |  | precioTrasOferta | double/Double | - | Por valor | no final | Valor calculado al aplicar el descuento correspondiente al precio del producto en cuestión |  |
|  |  |  |  | stock | int/Integer | - | Por valor | no final | Cantidad de unidades disponibles del producto en la sede |  |
|  |  |  |  | stockGarantia | int/Integer | - | Por valor | no final | Cantidad de unidades que necesitan cambio del producto específico en la sede |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del inventario físico producto-sede | void | - | No aplica |
| public | getProducto | getter | no final | Método encargado de obtener el valor del atributo producto | No aplica |  |  |  |  |  | Otro | Producto | No aplica |
| public | setProducto | setter | no final | Método encargado de colocar el valor al atributo producto | valorProducto | Otro | Producto | Por valor | no final | Producto del catálogo general de la empresa | void | - | No aplica |
| public | getSede | getter | no final | Método encargado de obtener el valor del atributo sede | No aplica |  |  |  |  |  | Otro | Sede | No aplica |
| public | setSede | setter | no final | Método encargado de colocar el valor al atributo sede | valorSede | Otro | Sede | Por valor | no final | Nombre de la sede donde se encuentra el inventario | void | - | No aplica |
| public | getPrecio | getter | no final | Método encargado de obtener el valor del atributo precio | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setPrecio | setter | no final | Método encargado de colocar el valor al atributo precio | valorPrecio | double/Double | - | Por valor | no final | Precio de venta local del producto en la sede | void | - | No aplica |
| public | getTieneOferta | getter | no final | Método encargado de obtener el valor del atributo tieneOferta | No aplica |  |  |  |  |  | boolean/Boolean | - | No aplica |
| public | setTieneOferta | setter | no final | Método encargado de colocar el valor al atributo tieneOferta | valorTieneOferta | boolean/Boolean | - | Por valor | no final | Variable booleana que define si un producto específico en una sede tiene oferta actualmente o no | void | - | No aplica |
| public | getOferta | getter | no final | Método encargado de obtener el valor del atributo oferta | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setOferta | setter | no final | Método encargado de colocar el valor al atributo oferta | valorOferta | int/Integer | - | Por valor | no final | Oferta que se le aplica al producto correspondiente, definida por el administrador | void | - | No aplica |
| public | getPrecioTrasOferta | getter | no final | Método encargado de obtener el valor del atributo precioTrasOferta | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setPrecioTrasOferta | setter | no final | Método encargado de colocar el valor al atributo precioTrasOferta | valorPrecioTrasOferta | double/Double | - | Por valor | no final | Valor calculado al aplicar el descuento correspondiente al precio del producto en cuestión | void | - | No aplica |
| public | getStock | getter | no final | Método encargado de obtener el valor del atributo stock | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setStock | setter | no final | Método encargado de colocar el valor al atributo stock | valorStock | int/Integer | - | Por valor | no final | Cantidad de unidades disponibles del producto en la sede | void | - | No aplica |
| public | getStockGarantia | getter | no final | Método encargado de obtener el valor del atributo stockGarantia | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setStockGarantia | setter | no final | Método encargado de colocar el valor al atributo stockGarantia | valorStockGarantia | int/Integer | - | Por valor | no final | Cantidad de unidades que necesitan cambio del producto específico en la sede | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarProductoSede | no static | no final | Permite registrar un nuevo producto de sede en el sistema | datos | Otro | ProductoSede | Por valor | no final | Contiene la información requerida para registrar el producto de sede | Otro | ProductoSede | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un producto de sede con ese mismo Producto |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosProductosSede | no static | no final | Permite consultar la información detallada de los productos de sede registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;ProductoSede&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarProductosSedePorFiltro | no static | no final | Permite buscar, listar y filtrar los productos de sede según los criterios de búsqueda enviados | filtro | Otro | ProductoSede | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;ProductoSede&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarProductoSede | no static | no final | Permite actualizar la información de un producto de sede existente | datos | Otro | ProductoSede | Por valor | no final | Tiene el identificador único del producto de sede a modificar y la nueva información | Otro | ProductoSede | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el producto de sede no existe o no puede ser modificado |
| public | aplicarOferta | no static | no final | Permite aplicar un porcentaje de oferta al producto de una sede y recalcular su precio tras la oferta | datos | Otro | ProductoSede | Por valor | no final | Contiene el identificador del producto de sede y el porcentaje de oferta a aplicar | Otro | ProductoSede | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el porcentaje de oferta es inválido |
| public | retirarStockGarantia | no static | no final | Permite retirar una cantidad determinada de unidades del stockGarantia de un ProductoSede ingresadas por el administrador | datos | Otro | ProductoSede | Por valor | no final | Contiene el identificador del producto de sede y la cantidad de unidades de garantía que se desean retirar | Otro | ProductoSede | Generar una excepción indicando que la cantidad ingresada a retirar es inválida o no ha sido ingresada |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que no hay unidades suficientes en el stock de garantía |

[↑ Volver al índice](#clases)

---

## Administrador

**Descripción:** Representa la especialización del empleado con permisos administrativos sobre la operación del negocio.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Empleado |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del administrador |
| private | empleado | Otro | Empleado | no final | no static | - | Referencia al empleado que desempeña el rol de administrador |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Administrador | Defecto | Constructor por defecto que crea una instancia de Administrador sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Administrador | Parametrizado | Constructor parametrizado que crea una instancia de Administrador inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del administrador | No aplica |
|  |  |  |  | empleado | Otro | Empleado | Por valor | no final | Referencia al empleado que desempeña el rol de administrador |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del administrador | void | - | No aplica |
| public | getEmpleado | getter | no final | Método encargado de obtener el valor del atributo empleado | No aplica |  |  |  |  |  | Otro | Empleado | No aplica |
| public | setEmpleado | setter | no final | Método encargado de colocar el valor al atributo empleado | valorEmpleado | Otro | Empleado | Por valor | no final | Referencia al empleado que desempeña el rol de administrador | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarAdministrador | no static | no final | Permite registrar un nuevo administrador en el sistema | datos | Otro | Administrador | Por valor | no final | Contiene la información requerida para registrar el administrador | Otro | Administrador | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un administrador con ese mismo Empleado |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosAdministradores | no static | no final | Permite consultar la información detallada de los administradores registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Administrador&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarAdministradoresPorFiltro | no static | no final | Permite buscar, listar y filtrar los administradores según los criterios de búsqueda enviados | filtro | Otro | Administrador | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Administrador&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## Vendedor

**Descripción:** Representa la especialización del empleado encargado de atender a los clientes en la sede.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Empleado |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del vendedor |
| private | empleado | Otro | Empleado | no final | no static | - | Referencia al empleado que desempeña el rol de vendedor |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Vendedor | Defecto | Constructor por defecto que crea una instancia de Vendedor sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Vendedor | Parametrizado | Constructor parametrizado que crea una instancia de Vendedor inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del vendedor | No aplica |
|  |  |  |  | empleado | Otro | Empleado | Por valor | no final | Referencia al empleado que desempeña el rol de vendedor |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del vendedor | void | - | No aplica |
| public | getEmpleado | getter | no final | Método encargado de obtener el valor del atributo empleado | No aplica |  |  |  |  |  | Otro | Empleado | No aplica |
| public | setEmpleado | setter | no final | Método encargado de colocar el valor al atributo empleado | valorEmpleado | Otro | Empleado | Por valor | no final | Referencia al empleado que desempeña el rol de vendedor | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarVendedor | no static | no final | Permite registrar un nuevo vendedor en el sistema | datos | Otro | Vendedor | Por valor | no final | Contiene la información requerida para registrar el vendedor | Otro | Vendedor | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un vendedor con ese mismo Empleado |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosVendedores | no static | no final | Permite consultar la información detallada de los vendedores registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Vendedor&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarVendedoresPorFiltro | no static | no final | Permite buscar, listar y filtrar los vendedores según los criterios de búsqueda enviados | filtro | Otro | Vendedor | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Vendedor&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## ProcesoCompra

**Descripción:** Representa el flujo que controla los estados y transiciones de una compra.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Cliente |
| Necesita de | Asociación | Empleado |
| Es usada por | Asociación | Compra |
| Es usada por | Asociación | DetalleCompra |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del proceso de compra |
| private | cliente | Otro | Cliente | no final | no static | - | Cliente asociado al proceso de compra |
| private | empleado | Otro | Empleado | no final | no static | - | Empleado responsable del proceso de compra |
| private | fechaInicio | Date | - | no final | no static | - | Fecha de inicio del proceso de la compra |
| private | fechaActualizacion | Date | - | no final | no static | - | Fecha de última actualización del proceso de la compra |
| private | totalCompra | double/Double | - | no final | no static | - | Valor total de la compra, se confirma el cálculo cuando el estado es Creado |
| private | estado | String | - | no final | no static | En Proceso | Estado actual del proceso (En proceso, Anulado y Creado) |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | ProcesoCompra | Defecto | Constructor por defecto que crea una instancia de ProcesoCompra sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | ProcesoCompra | Parametrizado | Constructor parametrizado que crea una instancia de ProcesoCompra inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del proceso de compra | No aplica |
|  |  |  |  | cliente | Otro | Cliente | Por valor | no final | Cliente asociado al proceso de compra |  |
|  |  |  |  | empleado | Otro | Empleado | Por valor | no final | Empleado responsable del proceso de compra |  |
|  |  |  |  | fechaInicio | Date | - | Por valor | no final | Fecha de inicio del proceso de la compra |  |
|  |  |  |  | fechaActualizacion | Date | - | Por valor | no final | Fecha de última actualización del proceso de la compra |  |
|  |  |  |  | totalCompra | double/Double | - | Por valor | no final | Valor total de la compra, se confirma el cálculo cuando el estado es Creado |  |
|  |  |  |  | estado | String | - | Por valor | no final | Estado actual del proceso (En proceso, Anulado y Creado) |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del proceso de compra | void | - | No aplica |
| public | getCliente | getter | no final | Método encargado de obtener el valor del atributo cliente | No aplica |  |  |  |  |  | Otro | Cliente | No aplica |
| public | setCliente | setter | no final | Método encargado de colocar el valor al atributo cliente | valorCliente | Otro | Cliente | Por valor | no final | Cliente asociado al proceso de compra | void | - | No aplica |
| public | getEmpleado | getter | no final | Método encargado de obtener el valor del atributo empleado | No aplica |  |  |  |  |  | Otro | Empleado | No aplica |
| public | setEmpleado | setter | no final | Método encargado de colocar el valor al atributo empleado | valorEmpleado | Otro | Empleado | Por valor | no final | Empleado responsable del proceso de compra | void | - | No aplica |
| public | getFechaInicio | getter | no final | Método encargado de obtener el valor del atributo fechaInicio | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaInicio | setter | no final | Método encargado de colocar el valor al atributo fechaInicio | valorFechaInicio | Date | - | Por valor | no final | Fecha de inicio del proceso de la compra | void | - | No aplica |
| public | getFechaActualizacion | getter | no final | Método encargado de obtener el valor del atributo fechaActualizacion | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaActualizacion | setter | no final | Método encargado de colocar el valor al atributo fechaActualizacion | valorFechaActualizacion | Date | - | Por valor | no final | Fecha de última actualización del proceso de la compra | void | - | No aplica |
| public | getTotalCompra | getter | no final | Método encargado de obtener el valor del atributo totalCompra | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setTotalCompra | setter | no final | Método encargado de colocar el valor al atributo totalCompra | valorTotalCompra | double/Double | - | Por valor | no final | Valor total de la compra, se confirma el cálculo cuando el estado es Creado | void | - | No aplica |
| public | getEstado | getter | no final | Método encargado de obtener el valor del atributo estado | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setEstado | setter | no final | Método encargado de colocar el valor al atributo estado | valorEstado | String | - | Por valor | no final | Estado actual del proceso (En proceso, Anulado y Creado) | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarProcesoCompra | no static | no final | Permite registrar un nuevo proceso de compra en el sistema | datos | Otro | ProcesoCompra | Por valor | no final | Contiene la información requerida para registrar el proceso de compra | Otro | ProcesoCompra | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un proceso de compra con ese mismo Cliente |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosProcesosCompra | no static | no final | Permite consultar la información detallada de los procesos de compra registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;ProcesoCompra&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarProcesosCompraPorFiltro | no static | no final | Permite buscar, listar y filtrar los procesos de compra según los criterios de búsqueda enviados | filtro | Otro | ProcesoCompra | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;ProcesoCompra&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarProcesoCompra | no static | no final | Permite actualizar la información de un proceso de compra existente | datos | Otro | ProcesoCompra | Por valor | no final | Tiene el identificador único del proceso de compra a modificar y la nueva información | Otro | ProcesoCompra | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el proceso de compra no existe o no puede ser modificado |

[↑ Volver al índice](#clases)

---

## DetalleIngreso

**Descripción:** Representa el detalle de cada producto que entró de mercancía al negocio, su cantidad, precio y demás atributos.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | IngresoInventario |
| Necesita de | Asociación | ProductoSede |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de cada detalle del ingreso |
| private | ingresoInventario | Otro | IngresoInventario | no final | no static | - | Factura de ingreso de inventario al que pertenece cada detalle de producto correspondiente |
| private | productoSede | Otro | ProductoSede | no final | no static | - | Hace referencia al producto-sede que ingresa en la factura correspondiente |
| private | cantidad | int/Integer | - | no final | no static | - | Cantidad de unidades que ingresan de ese producto |
| private | costoUnitario | double/Double | - | no final | no static | - | Costo de compra por unidad al proveedor |
| private | subtotal | double/Double | - | no final | no static | - | Resultado de cantidad por el costo unitario del producto |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | DetalleIngreso | Defecto | Constructor por defecto que crea una instancia de DetalleIngreso sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | DetalleIngreso | Parametrizado | Constructor parametrizado que crea una instancia de DetalleIngreso inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de cada detalle del ingreso | No aplica |
|  |  |  |  | ingresoInventario | Otro | IngresoInventario | Por valor | no final | Factura de ingreso de inventario al que pertenece cada detalle de producto correspondiente |  |
|  |  |  |  | productoSede | Otro | ProductoSede | Por valor | no final | Hace referencia al producto-sede que ingresa en la factura correspondiente |  |
|  |  |  |  | cantidad | int/Integer | - | Por valor | no final | Cantidad de unidades que ingresan de ese producto |  |
|  |  |  |  | costoUnitario | double/Double | - | Por valor | no final | Costo de compra por unidad al proveedor |  |
|  |  |  |  | subtotal | double/Double | - | Por valor | no final | Resultado de cantidad por el costo unitario del producto |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de cada detalle del ingreso | void | - | No aplica |
| public | getIngresoInventario | getter | no final | Método encargado de obtener el valor del atributo ingresoInventario | No aplica |  |  |  |  |  | Otro | IngresoInventario | No aplica |
| public | setIngresoInventario | setter | no final | Método encargado de colocar el valor al atributo ingresoInventario | valorIngresoInventario | Otro | IngresoInventario | Por valor | no final | Factura de ingreso de inventario al que pertenece cada detalle de producto correspondiente | void | - | No aplica |
| public | getProductoSede | getter | no final | Método encargado de obtener el valor del atributo productoSede | No aplica |  |  |  |  |  | Otro | ProductoSede | No aplica |
| public | setProductoSede | setter | no final | Método encargado de colocar el valor al atributo productoSede | valorProductoSede | Otro | ProductoSede | Por valor | no final | Hace referencia al producto-sede que ingresa en la factura correspondiente | void | - | No aplica |
| public | getCantidad | getter | no final | Método encargado de obtener el valor del atributo cantidad | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setCantidad | setter | no final | Método encargado de colocar el valor al atributo cantidad | valorCantidad | int/Integer | - | Por valor | no final | Cantidad de unidades que ingresan de ese producto | void | - | No aplica |
| public | getCostoUnitario | getter | no final | Método encargado de obtener el valor del atributo costoUnitario | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setCostoUnitario | setter | no final | Método encargado de colocar el valor al atributo costoUnitario | valorCostoUnitario | double/Double | - | Por valor | no final | Costo de compra por unidad al proveedor | void | - | No aplica |
| public | getSubtotal | getter | no final | Método encargado de obtener el valor del atributo subtotal | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setSubtotal | setter | no final | Método encargado de colocar el valor al atributo subtotal | valorSubtotal | double/Double | - | Por valor | no final | Resultado de cantidad por el costo unitario del producto | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarDetalleIngreso | no static | no final | Permite registrar un nuevo detalle de ingreso en el sistema | datos | Otro | DetalleIngreso | Por valor | no final | Contiene la información requerida para registrar el detalle de ingreso | Otro | DetalleIngreso | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un detalle de ingreso con ese mismo IngresoInventario |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosDetallesIngreso | no static | no final | Permite consultar la información detallada de los detalles de ingreso registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;DetalleIngreso&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarDetallesIngresoPorFiltro | no static | no final | Permite buscar, listar y filtrar los detalles de ingreso según los criterios de búsqueda enviados | filtro | Otro | DetalleIngreso | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;DetalleIngreso&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarDetalleIngreso | no static | no final | Permite actualizar la información de un detalle de ingreso existente | datos | Otro | DetalleIngreso | Por valor | no final | Tiene el identificador único del detalle de ingreso a modificar y la nueva información | Otro | DetalleIngreso | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el detalle de ingreso no existe o no puede ser modificado |
| public | eliminarDetalleIngreso | no static | no final | Permite eliminar un detalle de ingreso de un ingreso de inventario asociado, siempre y cuando no se haya creado | id | Otro | UUID | Por valor | no final | Contiene el identificador único del detalle ingreso que se desea eliminar | void | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que no se puede registrar o modificar el detalle ingreso correctamente |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya no es posible modificar o eliminar el detalle de ingreso debido al estado del ingreso |

[↑ Volver al índice](#clases)

---

## DetalleCompra

**Descripción:** Representa el detalle de cada producto que se vendió en una sede específica, su cantidad, precio y demás atributos.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | ProcesoCompra |
| Necesita de | Asociación | ProductoSede |
| Es usada por | Asociación | Devolucion |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la línea de detalle de la compra |
| private | procesoCompra | Otro | ProcesoCompra | no final | no static | - | Identificación del proceso de compra al que pertenece el detalle de compra del producto correspondiente |
| private | productoSede | Otro | ProductoSede | no final | no static | - | Hace referencia al producto en su sede correspondiente en la que se realizó la venta |
| private | cantidad | int/Integer | - | no final | no static | - | Cantidad de unidades vendidas de ese producto |
| private | precioUnitario | double/Double | - | no final | no static | - | Precio de venta por unidad en el momento de la compra; queda permanente en el tiempo aunque cambie el precio del producto |
| private | subtotal | double/Double | - | no final | no static | - | Resultado de cantidad por el precio unitario del producto |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | DetalleCompra | Defecto | Constructor por defecto que crea una instancia de DetalleCompra sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | DetalleCompra | Parametrizado | Constructor parametrizado que crea una instancia de DetalleCompra inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la línea de detalle de la compra | No aplica |
|  |  |  |  | procesoCompra | Otro | ProcesoCompra | Por valor | no final | Identificación del proceso de compra al que pertenece el detalle de compra del producto correspondiente |  |
|  |  |  |  | productoSede | Otro | ProductoSede | Por valor | no final | Hace referencia al producto en su sede correspondiente en la que se realizó la venta |  |
|  |  |  |  | cantidad | int/Integer | - | Por valor | no final | Cantidad de unidades vendidas de ese producto |  |
|  |  |  |  | precioUnitario | double/Double | - | Por valor | no final | Precio de venta por unidad en el momento de la compra; queda permanente en el tiempo aunque cambie el precio del producto |  |
|  |  |  |  | subtotal | double/Double | - | Por valor | no final | Resultado de cantidad por el precio unitario del producto |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la línea de detalle de la compra | void | - | No aplica |
| public | getProcesoCompra | getter | no final | Método encargado de obtener el valor del atributo procesoCompra | No aplica |  |  |  |  |  | Otro | ProcesoCompra | No aplica |
| public | setProcesoCompra | setter | no final | Método encargado de colocar el valor al atributo procesoCompra | valorProcesoCompra | Otro | ProcesoCompra | Por valor | no final | Identificación del proceso de compra al que pertenece el detalle de compra del producto correspondiente | void | - | No aplica |
| public | getProductoSede | getter | no final | Método encargado de obtener el valor del atributo productoSede | No aplica |  |  |  |  |  | Otro | ProductoSede | No aplica |
| public | setProductoSede | setter | no final | Método encargado de colocar el valor al atributo productoSede | valorProductoSede | Otro | ProductoSede | Por valor | no final | Hace referencia al producto en su sede correspondiente en la que se realizó la venta | void | - | No aplica |
| public | getCantidad | getter | no final | Método encargado de obtener el valor del atributo cantidad | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setCantidad | setter | no final | Método encargado de colocar el valor al atributo cantidad | valorCantidad | int/Integer | - | Por valor | no final | Cantidad de unidades vendidas de ese producto | void | - | No aplica |
| public | getPrecioUnitario | getter | no final | Método encargado de obtener el valor del atributo precioUnitario | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setPrecioUnitario | setter | no final | Método encargado de colocar el valor al atributo precioUnitario | valorPrecioUnitario | double/Double | - | Por valor | no final | Precio de venta por unidad en el momento de la compra; queda permanente en el tiempo aunque cambie el precio del producto | void | - | No aplica |
| public | getSubtotal | getter | no final | Método encargado de obtener el valor del atributo subtotal | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setSubtotal | setter | no final | Método encargado de colocar el valor al atributo subtotal | valorSubtotal | double/Double | - | Por valor | no final | Resultado de cantidad por el precio unitario del producto | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarDetalleCompra | no static | no final | Permite registrar un nuevo detalle de compra en el sistema | datos | Otro | DetalleCompra | Por valor | no final | Contiene la información requerida para registrar el detalle de compra | Otro | DetalleCompra | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un detalle de compra con esa misma Compra |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosDetallesCompra | no static | no final | Permite consultar la información detallada de los detalles de compra registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;DetalleCompra&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarDetallesCompraPorFiltro | no static | no final | Permite buscar, listar y filtrar los detalles de compra según los criterios de búsqueda enviados | filtro | Otro | DetalleCompra | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;DetalleCompra&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarDetalleCompra | no static | no final | Permite actualizar la información de un detalle de compra existente | datos | Otro | DetalleCompra | Por valor | no final | Tiene el identificador único del detalle de compra a modificar y la nueva información | Otro | DetalleCompra | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el detalle de compra no existe o no puede ser modificado |
| public | inhabilitarOEliminarDetalleCompra | no static | no final | Permite inhabilitar o eliminar un detalle de compra conservando la trazabilidad de su historial | id | Otro | UUID | Por valor | no final | Contiene el identificador único del detalle de compra que se desea inhabilitar o eliminar | boolean/Boolean | - | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando al usuario que el objeto de dominio está presente dentro de otro objeto |

[↑ Volver al índice](#clases)

---

## Compra

**Descripción:** Representa la transacción en la que un cliente adquiere uno o varios productos en una sede, es atendida por un empleado.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | ProcesoCompra |
| Es usada por | Asociación | Factura |
| Es usada por | Asociación | Pago |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la compra |
| private | procesoCompra | Otro | ProcesoCompra | no final | no static | - | Proceso de compra asociado a la compra |
| private | fechaCompra | Date | - | no final | no static | - | Fecha en que se realiza la compra |
| private | estado | String | - | no final | no static | Pendiente | Estado actual de la compra (Pendiente, Pagado y Anulado) |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Compra | Defecto | Constructor por defecto que crea una instancia de Compra sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Compra | Parametrizado | Constructor parametrizado que crea una instancia de Compra inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la compra | No aplica |
|  |  |  |  | procesoCompra | Otro | ProcesoCompra | Por valor | no final | Proceso de compra asociado a la compra |  |
|  |  |  |  | fechaCompra | Date | - | Por valor | no final | Fecha en que se realiza la compra |  |
|  |  |  |  | estado | String | - | Por valor | no final | Estado actual de la compra (Pendiente, Pagado y Anulado) |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la compra | void | - | No aplica |
| public | getProcesoCompra | getter | no final | Método encargado de obtener el valor del atributo procesoCompra | No aplica |  |  |  |  |  | Otro | ProcesoCompra | No aplica |
| public | setProcesoCompra | setter | no final | Método encargado de colocar el valor al atributo procesoCompra | valorProcesoCompra | Otro | ProcesoCompra | Por valor | no final | Proceso de compra asociado a la compra | void | - | No aplica |
| public | getFechaCompra | getter | no final | Método encargado de obtener el valor del atributo fechaCompra | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaCompra | setter | no final | Método encargado de colocar el valor al atributo fechaCompra | valorFechaCompra | Date | - | Por valor | no final | Fecha en que se realiza la compra | void | - | No aplica |
| public | getEstado | getter | no final | Método encargado de obtener el valor del atributo estado | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setEstado | setter | no final | Método encargado de colocar el valor al atributo estado | valorEstado | String | - | Por valor | no final | Estado actual de la compra (Pendiente, Pagado y Anulado) | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarCompra | no static | no final | Permite registrar una nueva compra en el sistema | datos | Otro | Compra | Por valor | no final | Contiene la información requerida para registrar la compra | Otro | Compra | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una compra con ese mismo ProcesoCompra |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasCompras | no static | no final | Permite consultar la información detallada de las compras registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Compra&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarComprasPorFiltro | no static | no final | Permite buscar, listar y filtrar las compras según los criterios de búsqueda enviados | filtro | Otro | Compra | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Compra&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarCompra | no static | no final | Permite actualizar la información de una compra existente | datos | Otro | Compra | Por valor | no final | Tiene el identificador único de la compra a modificar y la nueva información | Otro | Compra | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que la compra no existe o no puede ser modificada |
| public | calcularTotalCompra | no static | no final | Permite calcular el valor total de la compra a partir de los subtotales de sus detalles | id | Otro | UUID | Por valor | no final | Contiene el identificador único de la compra sobre la que se calcula el total | double/Double | - | Informar con un mensaje de error si la compra no existe o no puede ser recuperada |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Recalcular el total a partir de los detalles registrados de la compra |

[↑ Volver al índice](#clases)

---

## Pago

**Descripción:** Representa el abono que realiza el cliente para saldar una compra.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Compra |
| Es usada por | Asociación | AplicacionSaldo |
| Es usada por | Asociación | PagoNormal |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del pago |
| private | compra | Otro | Compra | no final | no static | - | Identificación de la compra que se está saldando |
| private | montoPendiente | double/Double | - | no final | no static | - | Valor abonado por el cliente en este pago |
| private | fechaPago | Date | - | no final | no static | - | Fecha en que se realiza el abono |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Pago | Defecto | Constructor por defecto que crea una instancia de Pago sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Pago | Parametrizado | Constructor parametrizado que crea una instancia de Pago inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del pago | No aplica |
|  |  |  |  | compra | Otro | Compra | Por valor | no final | Identificación de la compra que se está saldando |  |
|  |  |  |  | montoPendiente | double/Double | - | Por valor | no final | Valor abonado por el cliente en este pago |  |
|  |  |  |  | fechaPago | Date | - | Por valor | no final | Fecha en que se realiza el abono |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del pago | void | - | No aplica |
| public | getCompra | getter | no final | Método encargado de obtener el valor del atributo compra | No aplica |  |  |  |  |  | Otro | Compra | No aplica |
| public | setCompra | setter | no final | Método encargado de colocar el valor al atributo compra | valorCompra | Otro | Compra | Por valor | no final | Identificación de la compra que se está saldando | void | - | No aplica |
| public | getMontoPendiente | getter | no final | Método encargado de obtener el valor del atributo montoPendiente | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setMontoPendiente | setter | no final | Método encargado de colocar el valor al atributo montoPendiente | valorMontoPendiente | double/Double | - | Por valor | no final | Valor abonado por el cliente en este pago | void | - | No aplica |
| public | getFechaPago | getter | no final | Método encargado de obtener el valor del atributo fechaPago | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaPago | setter | no final | Método encargado de colocar el valor al atributo fechaPago | valorFechaPago | Date | - | Por valor | no final | Fecha en que se realiza el abono | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarPago | no static | no final | Permite registrar un nuevo pago en el sistema | datos | Otro | Pago | Por valor | no final | Contiene la información requerida para registrar el pago | Otro | Pago | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un pago con esa misma Compra |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosPagos | no static | no final | Permite consultar la información detallada de los pagos registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Pago&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarPagosPorFiltro | no static | no final | Permite buscar, listar y filtrar los pagos según los criterios de búsqueda enviados | filtro | Otro | Pago | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Pago&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## Factura

**Descripción:** Representa el comprobante legal de venta que se genera a partir de una compra ya pagada

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Compra |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la factura |
| private | compra | Otro | Compra | no final | no static | - | Identificación de la compra con la que se hace la factura |
| private | fechaEmision | Date | - | no final | no static | - | Fecha en que se emite la factura |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Factura | Defecto | Constructor por defecto que crea una instancia de Factura sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Factura | Parametrizado | Constructor parametrizado que crea una instancia de Factura inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la factura | No aplica |
|  |  |  |  | compra | Otro | Compra | Por valor | no final | Identificación de la compra con la que se hace la factura |  |
|  |  |  |  | fechaEmision | Date | - | Por valor | no final | Fecha en que se emite la factura |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la factura | void | - | No aplica |
| public | getCompra | getter | no final | Método encargado de obtener el valor del atributo compra | No aplica |  |  |  |  |  | Otro | Compra | No aplica |
| public | setCompra | setter | no final | Método encargado de colocar el valor al atributo compra | valorCompra | Otro | Compra | Por valor | no final | Identificación de la compra con la que se hace la factura | void | - | No aplica |
| public | getFechaEmision | getter | no final | Método encargado de obtener el valor del atributo fechaEmision | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaEmision | setter | no final | Método encargado de colocar el valor al atributo fechaEmision | valorFechaEmision | Date | - | Por valor | no final | Fecha en que se emite la factura | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarFactura | no static | no final | Permite registrar una nueva factura en el sistema | datos | Otro | Factura | Por valor | no final | Contiene la información requerida para registrar la factura | Otro | Factura | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una factura con esa misma Compra |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasFacturas | no static | no final | Permite consultar la información detallada de las facturas registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Factura&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarFacturasPorFiltro | no static | no final | Permite buscar, listar y filtrar las facturas según los criterios de búsqueda enviados | filtro | Otro | Factura | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Factura&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## Devolucion

**Descripción:** Representa la solicitud de un cliente de devolver un producto si cumple con las condiciones establecidas en el negocio.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | DetalleCompra |
| Necesita de | Asociación | Motivo |
| Es usada por | Asociación | SaldoFavor |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la devolución |
| private | detalleCompra | Otro | DetalleCompra | no final | no static | - | Producto comprado que el cliente desea devolver |
| private | motivo | Otro | Motivo | no final | no static | - | Motivo o razón por la cual el cliente devuelve el producto |
| private | fechaDevolucion | Date | - | no final | no static | - | Fecha en que el cliente solicita la devolución |
| private | cantidad | int/Integer | - | no final | no static | - | Cantidad de productos que el cliente desea devolver |
| private | montoDevolucion | double/Double | - | no final | no static | - | Monto de la devolución calculado con la cantidad del producto y su precio unitario en el detalleCompra |
| private | estado | String | - | no final | no static | Pendiente | Estado actual de la solicitud de devolución (Pendiente, Aprobada, Rechazada) |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | Devolucion | Defecto | Constructor por defecto que crea una instancia de Devolucion sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | Devolucion | Parametrizado | Constructor parametrizado que crea una instancia de Devolucion inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la devolución | No aplica |
|  |  |  |  | detalleCompra | Otro | DetalleCompra | Por valor | no final | Producto comprado que el cliente desea devolver |  |
|  |  |  |  | motivo | Otro | Motivo | Por valor | no final | Motivo o razón por la cual el cliente devuelve el producto |  |
|  |  |  |  | fechaDevolucion | Date | - | Por valor | no final | Fecha en que el cliente solicita la devolución |  |
|  |  |  |  | cantidad | int/Integer | - | Por valor | no final | Cantidad de productos que el cliente desea devolver |  |
|  |  |  |  | montoDevolucion | double/Double | - | Por valor | no final | Monto de la devolución calculado con la cantidad del producto y su precio unitario en el detalleCompra |  |
|  |  |  |  | estado | String | - | Por valor | no final | Estado actual de la solicitud de devolución (Pendiente, Aprobada, Rechazada) |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la devolución | void | - | No aplica |
| public | getDetalleCompra | getter | no final | Método encargado de obtener el valor del atributo detalleCompra | No aplica |  |  |  |  |  | Otro | DetalleCompra | No aplica |
| public | setDetalleCompra | setter | no final | Método encargado de colocar el valor al atributo detalleCompra | valorDetalleCompra | Otro | DetalleCompra | Por valor | no final | Producto comprado que el cliente desea devolver | void | - | No aplica |
| public | getMotivo | getter | no final | Método encargado de obtener el valor del atributo motivo | No aplica |  |  |  |  |  | Otro | Motivo | No aplica |
| public | setMotivo | setter | no final | Método encargado de colocar el valor al atributo motivo | valorMotivo | Otro | Motivo | Por valor | no final | Motivo o razón por la cual el cliente devuelve el producto | void | - | No aplica |
| public | getFechaDevolucion | getter | no final | Método encargado de obtener el valor del atributo fechaDevolucion | No aplica |  |  |  |  |  | Date | - | No aplica |
| public | setFechaDevolucion | setter | no final | Método encargado de colocar el valor al atributo fechaDevolucion | valorFechaDevolucion | Date | - | Por valor | no final | Fecha en que el cliente solicita la devolución | void | - | No aplica |
| public | getCantidad | getter | no final | Método encargado de obtener el valor del atributo cantidad | No aplica |  |  |  |  |  | int/Integer | - | No aplica |
| public | setCantidad | setter | no final | Método encargado de colocar el valor al atributo cantidad | valorCantidad | int/Integer | - | Por valor | no final | Cantidad de productos que el cliente desea devolver | void | - | No aplica |
| public | getMontoDevolucion | getter | no final | Método encargado de obtener el valor del atributo montoDevolucion | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setMontoDevolucion | setter | no final | Método encargado de colocar el valor al atributo montoDevolucion | valorMontoDevolucion | double/Double | - | Por valor | no final | Monto de la devolución calculado con la cantidad del producto y su precio unitario en el detalleCompra | void | - | No aplica |
| public | getEstado | getter | no final | Método encargado de obtener el valor del atributo estado | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setEstado | setter | no final | Método encargado de colocar el valor al atributo estado | valorEstado | String | - | Por valor | no final | Estado actual de la solicitud de devolución (Pendiente, Aprobada, Rechazada) | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarDevolucion | no static | no final | Permite registrar una nueva devolución en el sistema | datos | Otro | Devolucion | Por valor | no final | Contiene la información requerida para registrar la devolución | Otro | Devolucion | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una devolución con ese mismo DetalleCompra |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasDevoluciones | no static | no final | Permite consultar la información detallada de las devoluciones registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;Devolucion&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarDevolucionesPorFiltro | no static | no final | Permite buscar, listar y filtrar las devoluciones según los criterios de búsqueda enviados | filtro | Otro | Devolucion | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;Devolucion&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarDevolucion | no static | no final | Permite actualizar la información de una devolución existente | datos | Otro | Devolucion | Por valor | no final | Tiene el identificador único de la devolución a modificar y la nueva información | Otro | Devolucion | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que la devolución no existe o no puede ser modificada |

[↑ Volver al índice](#clases)

---

## PagoNormal

**Descripción:** Representa la especialización del pago realizado directamente por el cliente mediante un método de pago

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | MetodoPago |
| Necesita de | Asociación | Pago |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del pago normal |
| private | metodoPago | Otro | MetodoPago | no final | no static | - | Método de pago utilizado para realizar el pago normal |
| private | pago | Otro | Pago | no final | no static | - | Pago base asociado a la transacción realizada |
| private | montoPagar | double/Double | - | no final | no static | - | Indica la cantidad de dinero que se va a pagar en esta transacción |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | PagoNormal | Defecto | Constructor por defecto que crea una instancia de PagoNormal sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | PagoNormal | Parametrizado | Constructor parametrizado que crea una instancia de PagoNormal inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del pago normal | No aplica |
|  |  |  |  | metodoPago | Otro | MetodoPago | Por valor | no final | Método de pago utilizado para realizar el pago normal |  |
|  |  |  |  | pago | Otro | Pago | Por valor | no final | Pago base asociado a la transacción realizada |  |
|  |  |  |  | montoPagar | double/Double | - | Por valor | no final | Indica la cantidad de dinero que se va a pagar en esta transacción |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del pago normal | void | - | No aplica |
| public | getMetodoPago | getter | no final | Método encargado de obtener el valor del atributo metodoPago | No aplica |  |  |  |  |  | Otro | MetodoPago | No aplica |
| public | setMetodoPago | setter | no final | Método encargado de colocar el valor al atributo metodoPago | valorMetodoPago | Otro | MetodoPago | Por valor | no final | Método de pago utilizado para realizar el pago normal | void | - | No aplica |
| public | getPago | getter | no final | Método encargado de obtener el valor del atributo pago | No aplica |  |  |  |  |  | Otro | Pago | No aplica |
| public | setPago | setter | no final | Método encargado de colocar el valor al atributo pago | valorPago | Otro | Pago | Por valor | no final | Pago base asociado a la transacción realizada | void | - | No aplica |
| public | getMontoPagar | getter | no final | Método encargado de obtener el valor del atributo montoPagar | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setMontoPagar | setter | no final | Método encargado de colocar el valor al atributo montoPagar | valorMontoPagar | double/Double | - | Por valor | no final | Indica la cantidad de dinero que se va a pagar en esta transacción | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarPagoNormal | no static | no final | Permite registrar un nuevo pago normal en el sistema | datos | Otro | PagoNormal | Por valor | no final | Contiene la información requerida para registrar el pago normal | Otro | PagoNormal | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un pago normal con ese mismo MetodoPago |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosPagosNormales | no static | no final | Permite consultar la información detallada de los pagos normales registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;PagoNormal&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarPagosNormalesPorFiltro | no static | no final | Permite buscar, listar y filtrar los pagos normales según los criterios de búsqueda enviados | filtro | Otro | PagoNormal | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;PagoNormal&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)

---

## SaldoFavor

**Descripción:** Representa el saldo a favor del cliente generado por una devolución de mercancía.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Devolucion |
| Es usada por | Asociación | AplicacionSaldo |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único del saldo a favor |
| private | devolucion | Otro | Devolucion | no final | no static | - | Referencia a la devolución que generó el saldo a favor |
| private | montoDisponible | double/Double | - | no final | no static | - | Monto del saldo a favor que aún queda disponible para que el cliente lo use en nuevos pagos |
| private | estado | String | - | no final | no static | ACTIVO | Estado actual del saldo (Disponible, Aplicado y Anulado) |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | SaldoFavor | Defecto | Constructor por defecto que crea una instancia de SaldoFavor sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | SaldoFavor | Parametrizado | Constructor parametrizado que crea una instancia de SaldoFavor inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único del saldo a favor | No aplica |
|  |  |  |  | devolucion | Otro | Devolucion | Por valor | no final | Referencia a la devolución que generó el saldo a favor |  |
|  |  |  |  | montoDisponible | double/Double | - | Por valor | no final | Monto del saldo a favor que aún queda disponible para que el cliente lo use en nuevos pagos |  |
|  |  |  |  | estado | String | - | Por valor | no final | Estado actual del saldo (Disponible, Aplicado y Anulado) |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único del saldo a favor | void | - | No aplica |
| public | getDevolucion | getter | no final | Método encargado de obtener el valor del atributo devolucion | No aplica |  |  |  |  |  | Otro | Devolucion | No aplica |
| public | setDevolucion | setter | no final | Método encargado de colocar el valor al atributo devolucion | valorDevolucion | Otro | Devolucion | Por valor | no final | Referencia a la devolución que generó el saldo a favor | void | - | No aplica |
| public | getMontoDisponible | getter | no final | Método encargado de obtener el valor del atributo montoDisponible | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setMontoDisponible | setter | no final | Método encargado de colocar el valor al atributo montoDisponible | valorMontoDisponible | double/Double | - | Por valor | no final | Monto del saldo a favor que aún queda disponible para que el cliente lo use en nuevos pagos | void | - | No aplica |
| public | getEstado | getter | no final | Método encargado de obtener el valor del atributo estado | No aplica |  |  |  |  |  | String | - | No aplica |
| public | setEstado | setter | no final | Método encargado de colocar el valor al atributo estado | valorEstado | String | - | Por valor | no final | Estado actual del saldo (Disponible, Aplicado y Anulado) | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarSaldoFavor | no static | no final | Permite registrar un nuevo saldo a favor en el sistema | datos | Otro | SaldoFavor | Por valor | no final | Contiene la información requerida para registrar el saldo a favor | Otro | SaldoFavor | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe un saldo a favor con esa misma Devolución |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodosSaldosFavor | no static | no final | Permite consultar la información detallada de los saldos a favor registrados en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;SaldoFavor&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarSaldosFavorPorFiltro | no static | no final | Permite buscar, listar y filtrar los saldos a favor según los criterios de búsqueda enviados | filtro | Otro | SaldoFavor | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;SaldoFavor&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | modificarSaldoFavor | no static | no final | Permite actualizar la información de un saldo a favor existente | datos | Otro | SaldoFavor | Por valor | no final | Tiene el identificador único del saldo a favor a modificar y la nueva información | Otro | SaldoFavor | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el saldo a favor no existe o no puede ser modificado |
| public | descontarSaldoFavor | no static | no final | Permite descontar del monto disponible del saldo a favor el valor aplicado en un pago | datos | Otro | SaldoFavor | Por valor | no final | Contiene el identificador del saldo a favor y el valor que se desea descontar | Otro | SaldoFavor | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que el valor a descontar supera el monto disponible |

[↑ Volver al índice](#clases)

---

## AplicacionSaldo

**Descripción:** Representa el uso de un saldo a favor sobre un pago con saldo, y permite controlar el saldo de un cliente específico.

- **Estereotipo:** class
- **Modificador acceso:** public
- **Tipo clase:** no final

#### Relaciones

| Relación | Tipo relación | Estructura |
|---|---|---|
| Necesita de | Asociación | Pago |
| Necesita de | Asociación | SaldoFavor |

#### Atributos

| Modificador de acceso | Nombre | Tipo de dato | Tipo de dato / ¿Cuál? | Tipo modificación atributo | Tipo acceso atributo | Valor por defecto | Descripción atributo |
|---|---|---|---|---|---|---|---|
| private | id | Otro | UUID | no final | no static | - | Identificador único de la aplicación de saldo |
| private | saldoFavor | Otro | SaldoFavor | no final | no static | - | Referencia al saldo a favor del cliente del cual se toma el monto que se aplica |
| private | pago | Otro | Pago | no final | no static | - | Referencia al pago sobre el cual se aplica el saldo a favor |
| private | valorAplicado | double/Double | - | no final | no static | - | Monto del saldo a favor que se aplica en este pago |

#### Constructores

| Modificador de acceso | Nombre | Tipo constructor | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|
| public | AplicacionSaldo | Defecto | Constructor por defecto que crea una instancia de AplicacionSaldo sin inicializar sus atributos | No aplica |  |  |  |  |  | No aplica |
| public | AplicacionSaldo | Parametrizado | Constructor parametrizado que crea una instancia de AplicacionSaldo inicializando todos sus atributos con los valores recibidos por parámetro | id | Otro | UUID | Por valor | no final | Identificador único de la aplicación de saldo | No aplica |
|  |  |  |  | saldoFavor | Otro | SaldoFavor | Por valor | no final | Referencia al saldo a favor del cliente del cual se toma el monto que se aplica |  |
|  |  |  |  | pago | Otro | Pago | Por valor | no final | Referencia al pago sobre el cual se aplica el saldo a favor |  |
|  |  |  |  | valorAplicado | double/Double | - | Por valor | no final | Monto del saldo a favor que se aplica en este pago |  |

#### Métodos accesores

| Modificador de acceso | Nombre | Tipo método accesor | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | getId | getter | no final | Método encargado de obtener el valor del atributo id | No aplica |  |  |  |  |  | Otro | UUID | No aplica |
| public | setId | setter | no final | Método encargado de colocar el valor al atributo id | valorId | Otro | UUID | Por valor | no final | Identificador único de la aplicación de saldo | void | - | No aplica |
| public | getSaldoFavor | getter | no final | Método encargado de obtener el valor del atributo saldoFavor | No aplica |  |  |  |  |  | Otro | SaldoFavor | No aplica |
| public | setSaldoFavor | setter | no final | Método encargado de colocar el valor al atributo saldoFavor | valorSaldoFavor | Otro | SaldoFavor | Por valor | no final | Referencia al saldo a favor del cliente del cual se toma el monto que se aplica | void | - | No aplica |
| public | getPago | getter | no final | Método encargado de obtener el valor del atributo pago | No aplica |  |  |  |  |  | Otro | Pago | No aplica |
| public | setPago | setter | no final | Método encargado de colocar el valor al atributo pago | valorPago | Otro | Pago | Por valor | no final | Referencia al pago sobre el cual se aplica el saldo a favor | void | - | No aplica |
| public | getValorAplicado | getter | no final | Método encargado de obtener el valor del atributo valorAplicado | No aplica |  |  |  |  |  | double/Double | - | No aplica |
| public | setValorAplicado | setter | no final | Método encargado de colocar el valor al atributo valorAplicado | valorValorAplicado | double/Double | - | Por valor | no final | Monto del saldo a favor que se aplica en este pago | void | - | No aplica |

#### Métodos

| Modificador de acceso | Nombre | Tipo acceso método | Tipo modificación método | Descripción | Parámetros / Nombre | Parámetros / Tipo de dato | Parámetros / ¿Cuál? | Parámetros / Tipo parámetro | Parámetros / Tipo modificación atributo | Parámetros / Descripción | Tipo dato de retorno / Tipo de dato | Tipo dato de retorno / ¿Cuál? | Excepciones |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| public | registrarAplicacionSaldo | no static | no final | Permite registrar una nueva aplicación de saldo en el sistema | datos | Otro | AplicacionSaldo | Por valor | no final | Contiene la información requerida para registrar la aplicación de saldo | Otro | AplicacionSaldo | Generar un nuevo identificador hasta garantizar que no exista |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que ya existe una aplicación de saldo con ese mismo SaldoFavor |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
| public | consultarTodasAplicacionesSaldo | no static | no final | Permite consultar la información detallada de las aplicaciones de saldo registradas en el sistema | No aplica |  |  |  |  |  | Otro | List&lt;AplicacionSaldo&gt; | Informar con un mensaje de error si ocurre un fallo al recuperar la información |
| public | consultarAplicacionesSaldoPorFiltro | no static | no final | Permite buscar, listar y filtrar las aplicaciones de saldo según los criterios de búsqueda enviados | filtro | Otro | AplicacionSaldo | Por valor | no final | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Otro | List&lt;AplicacionSaldo&gt; | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos |
|  |  |  |  |  |  |  |  |  |  |  |  |  | Informar con un mensaje de error si ocurre un fallo al recuperar la información |

[↑ Volver al índice](#clases)
