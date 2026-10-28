# Modelo de Dominio — Saraitel

> Documentación generada a partir del archivo `Modelo_Dominio_Saraitel.xlsx`.

## Objetos de dominio

| # | Objeto | Descripción | Línea de vida |
|---|---|---|---|
| 1 | [Pais](#pais) | Representa el país al que pertenecen las sedes. | 1 |
| 2 | [MetodoPago](#metodopago) | Representa las formas en que un cliente puede cancelar una compra (efectivo, tarjeta, transferencia, Nequi, entre otras). | 1 |
| 3 | [Cliente](#cliente) | Representa a la persona que adquiere productos en cualquiera de las sedes del negocio. | 1 |
| 4 | [Marca](#marca) | Representa al fabricante de los accesorios y repuestos que comercializa el negocio. | 1 |
| 5 | [Motivo](#motivo) | Representa la razón por la que un cliente solicita devolver un producto. | 1 |
| 6 | [TipoDocumento](#tipodocumento) | Representa el tipo de documento de identidad de una persona | 1 |
| 7 | [Categoria](#categoria) | Representa la clasificación a la que pertenece un producto dentro del catálogo. | 1 |
| 8 | [Prefijo](#prefijo) | Representa el código de marcado telefónico asociado a un país para el registro de números de contacto | 1 |
| 9 | [Persona](#persona) | Representa a un individuo en el sistema con sus datos generales de identificación  para registrarse en el sistema | 2 |
| 10 | [Producto](#producto) | Representa un artículo del catálogo general del negocio, independiente de la sede en la que se encuentre. | 2 |
| 11 | [Departamento](#departamento) | Representa el departamento o división administrativa al que pertenece una ciudad dentro de un país. | 2 |
| 12 | [ClienteRegistrado](#clienteregistrado) | Representa al cliente cuyos datos de identificación y contacto han sido registrados en el sistema | 2 |
| 13 | [ClienteNoRegistrado](#clientenoregistrado) | Representa a la persona que realiza una compra sin contar con un registro previo en el sistema | 2 |
| 14 | [ClienteRegistradoN](#clienteregistradon) | Representa al cliente registrado natural en el sistema con sus datos básicos de identificación y contacto | 3 |
| 15 | [ClienteRegistradoJ](#clienteregistradoj) | Representa al cliente registrado Jurídico en el sistema con sus datos básicos de identificación y contacto | 3 |
| 16 | [Ciudad](#ciudad) | Representa la ciudad o municipio donde se ubican las sedes del negocio y residen los clientes. | 3 |
| 17 | [Sede](#sede) | Representa cada local físico del negocio, donde se atienden las compras y se almacena la mercancía. | 4 |
| 18 | [IngresoInventario](#ingresoinventario) | Representa la factura de la llegada de nueva mercancía a una sede por parte de un proveedor que la creó previamente. | 5 |
| 19 | [Empleado](#empleado) | Representa al personal contratado que trabaja en una sede específica, es quien atiende las compras de los clientes. | 5 |
| 20 | [ProductoSede](#productosede) | Representa el inventario real de un producto en una sede determinada. | 5 |
| 21 | [Administrador](#administrador) | Representa la especialización del empleado con permisos administrativos sobre la operación del negocio. | 6 |
| 22 | [Vendedor](#vendedor) | Representa la especialización del empleado encargado de atender a los clientes en la sede. | 6 |
| 23 | [ProcesoCompra](#procesocompra) | Representa el flujo que controla los estados y transiciones de una compra. | 6 |
| 24 | [DetalleIngreso](#detalleingreso) | Representa el detalle de cada producto que entró de mercancía al negocio, su cantidad, precio y demás atributos. | 6 |
| 25 | [DetalleCompra](#detallecompra) | Representa el detalle de cada producto que se vendió en una sede específica, su cantidad, precio y demás atributos. | 7 |
| 26 | [Compra](#compra) | Representa la transacción en la que un cliente adquiere uno o varios productos en una sede, es atendida por un empleado. | 7 |
| 27 | [Pago](#pago) | Representa el abono que realiza el cliente para saldar una compra. | 8 |
| 28 | [Factura](#factura) | Representa el comprobante legal de venta que se genera a partir de una compra ya pagada | 8 |
| 29 | [Devolución](#devolución) | Representa la solicitud de un cliente de devolver un producto si cumple con las condiciones establecidas en el negocio. | 8 |
| 30 | [PagoNormal](#pagonormal) | Representa la especialización del pago realizado directamente por el cliente mediante un método de pago | 9 |
| 31 | [SaldoFavor](#saldofavor) | Representa el saldo a favor del cliente generado por una devolución de mercancía. | 9 |
| 32 | [AplicacionSaldo](#aplicacionsaldo) | Representa el uso de un saldo a favor sobre un pago con saldo, y permite controlar el saldo de un cliente específico. | 10 |

---

## Pais

**Descripción:** Representa el país al que pertenecen las sedes.  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único del país
- **Nombre**: Nombre oficial del país
- **PaisUnico**: Combinación única que indica que no puede existir más de un país con el mismo nombre

| ID | Nombre | PaisUnico |
|---|---|---|
| 1 | Colombia | Colombia |
| 2 | Ecuador | Ecuador |
| 3 | Perú | Perú |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | buscarPaisPorFiltro | buscarPaisPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del país | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los países | No | No | - | No | No | - | - | Si | Filtro | No Mostrar |
| Nombre | Nombre oficial del país | No | Texto | Si | 2 | 100 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| PaisUnico | Combinación única que indica que no puede existir más de un país con el mismo nombre | Nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| buscarPaisPorFiltro | Permite buscar un país determinado por un criterio específico (nombre, id) | filtro | Pais | Contiene la información de los filtros que servirán como base para llevar a cabo la consulta de la información | Lista<Pais> | Contiene la información de todos los países que cumplen con el filtro de consulta | P-PAI-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Informar con un mensaje de error si ocurre un fallo al recuperar el catálogo de países | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/  Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador / Vendedor | Buscar país por filtro | Permite buscar un país determinado por un criterio específico (nombre, id) | Pais | Filtros de paises | Los parámetros de búsqueda ingresados por el usuario para filtrar el catálogo | P-PAI-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Paises encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PAI-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Pais |

[↑ Volver al índice](#objetos-de-dominio)

---

## MetodoPago

**Descripción:** Representa las formas en que un cliente puede cancelar una compra (efectivo, tarjeta, transferencia, Nequi, entre otras).  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único del método de pago
- **Nombre**: Nombre del método de pago disponible en el negocio
- **EsActivo**: Indica si el método de pago está disponible para utilizarse
- **MetodoUnico**: Combinación única que indica que no puede existir más de un método de pago con el mismo nombre

| ID | Nombre | EsActivo | MetodoUnico |
|---|---|---|---|
| 1 | Efectivo | SI | Efectivo |
| 2 | Tarjeta Débito | SI | Tarjeta Débito |
| 3 | Tarjeta Crédito | SI | Tarjeta Crédito |
| 4 | Nequi | SI | Nequi |
| 5 | Transferencia Bancaria | SI | Transferencia Bancaria |
| 7 | Wompi | NO | Wompi |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarMetodoPago | consultarMetodosPagoPorFiltro | consultarMetodosPagoPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del método de pago | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los métodos de pago | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Nombre | Nombre del método de pago disponible en el negocio | No | Texto | Si | 2 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar |
| EsActivo | Indica si el método de pago está disponible para utilizarse | No | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO y es ingresado por el administrador; al pasar a NO el registro se inhabilita pero se conserva su historial | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| MetodoUnico | Combinación única que indica que no puede existir más de un método de pago con el mismo nombre | Nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarMetodoPago | Permite agregar una nueva opción al catálogo de métodos de pago del sistema | datos | MetodoPago | Corresponde al nombre y estado del nuevo método de pago | MetodoPago | Objeto del método de pago registrado con su nombre y su estado correspondiente | P-MDP-001 | Asegurar que el id del metodo de pago sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-MDP-002 | Asegurar que el  nombre del método sea único e irrepetible | Generar una excepción indicando que ya existe un metodo de pago registrado con ese nombre | Detener operación |
|  |  |  |  |  |  |  | P-MDP-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Informar con un mensaje de error si los parámetros de consulta son inválidos | Detener operación |
| consultarMetodosPagoPorFiltro | Permite buscar por filtro y visualizar los métodos de pago habilitados para realizar transacciones | filtro | MetodoPago | Los parámetros de búsqueda ingresados por el usuario para filtrar el catálogo | Lista<MetodoPago> | Contiene la lista de métodos de pago que cumplen con las condiciones del filtro enviado | P-MDP-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Informar con un mensaje de error si los parámetros de filtro de consulta son inválidos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo método de pago | Permite agregar una nueva opción al catálogo de métodos de pago del sistema | MetodoPago | Datos del método de pago | Corresponde al nombre y estado del nuevo método de pago | P-MDP-001 | Asegurar que el id del metodo de pago sea único e irrepetible |  | Método de pago registrado |  |
|  |  |  |  |  |  | P-MDP-002 | Asegurar que el  nombre del método sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-MDP-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Buscar método por criterio | Permite buscar por filtro y visualizar los métodos de pago habilitados para realizar transacciones | MetodoPago | Filtros de los metodos de pago | Los parámetros de búsqueda ingresados por el usuario para filtrar el catálogo | P-MDP-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Métodos de pago encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-MDP-001 | Asegurar que el id del metodo de pago sea único e irrepetible | MetodoPago |
| P-MDP-002 | Asegurar que el  nombre del método sea único e irrepetible | MetodoPago |
| P-MDP-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | MetodoPago |

[↑ Volver al índice](#objetos-de-dominio)

---

## Cliente

**Descripción:** Representa a la persona que adquiere productos en cualquiera de las sedes del negocio.  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único del cliente
- **ClientePorDefecto**: Indica si la compra debe asociarse al cliente no registrado cuando el comprador no se desea ser registrado en el sistema.

| ID | ClientePorDefecto |
|---|---|
| 1 | SI |
| 2 | NO |
| 3 | NO |
| 4 | SI |
| 5 | NO |
| 6 | SI |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarCliente | consultarClientesPorFiltro | consultarClientesPorFiltro | eliminarCliente |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del cliente | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los clientes | No | No | - | No | No | - | - | Si | Requerido | Filtro | No mostrar | Requerido |
| ClientePorDefecto | Indica si la compra debe asociarse al cliente no registrado cuando el comprador no se desea ser registrado en el sistema. | Si | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO y es ingresado por el administrador; al pasar a NO el registro no se realiza pero se conserva su historial | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido |

| Responsabilidades | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarCliente | Crea el registro base del cliente asignando un ID universal y definiendo si es el cliente por defecto | datos | Cliente | Contiene la información requerida para registrar el cliente | Cliente | Objeto del cliente registrado con su identificador ID asignado y estados por defecto | P-CLI-001 | Asegurar que el id del cliente sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-CLI-002 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarClientesPorFiltro | Los parámetros de búsqueda ingresados por el usuario para filtrar la lista de clientes | filtro | Cliente | Contiene los parámetros o criterios de consulta enviados para filtrar la búsqueda | Lista<Cliente> | Contiene la lista de clientes que cumplen con las condiciones del filtro enviado | P-CLI-002 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| eliminarCliente | Permite eliminar un cliente, borrando todo su historial de compras y de devoluciones, solo si el cliente registrado lo desea | id | UUID | Contiene el identificador único del cliente que se desea eliminar |  |  | P-CLI-003 | Asegurar que el cliente no esté siendo utilizado dentro de otro objeto de dominio | Generar una excepción indicando al usuario que el cliente está siendo usado por otros tipos de cliente (cliente registrado o no registrado) | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo cliente | Crea el registro base del cliente asignando un ID universal y definiendo si es el cliente por defecto | Cliente | Datos del nuevo cliente | Corresponde a la asignación interna del id del cliente y el registro de su tipo | P-CLI-001 | Asegurar que el id del cliente sea único e irrepetible |  | Cliente registrado |  |
|  |  |  |  |  |  | P-CLI-002 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Buscar cliente por criterio | Permite buscar por filtro y visualizar los clientes disponibles para realizar compras | Cliente | Filtros del id y estados de cliente | Los parámetros de búsqueda ingresados por el usuario para filtrar el cliente | P-CLI-002 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Clientes encontrados |  |
| Administrador | Eliminar cliente | Permite eliminar el registro de un cliente del catálogo del sistema | Cliente | Datos cliente(id) | Identificador único del cliente que se desea retirar o inactivar | P-CLI-002 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Cliente eliminado |  |
|  |  |  |  |  |  | P-CLI-003 | Asegurar que el cliente no esté siendo utilizado dentro de otro objeto de dominio |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CLI-001 | Asegurar que el id del cliente sea único e irrepetible | Cliente |
| P-CLI-002 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Cliente |
| P-CLI-003 | Asegurar que el cliente no esté siendo utilizado dentro de otro objeto de dominio | Cliente |

[↑ Volver al índice](#objetos-de-dominio)

---

## Marca

**Descripción:** Representa al fabricante de los accesorios y repuestos que comercializa el negocio.  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único de la marca
- **Nombre**: Nombre del fabricante de los productos
- **EsActivo**: Variable booleana que define si una marca específica sigue siendo usada en la empresa
- **MarcaUnica**: Combinación única que indica que no puede existir más de una marca con el mismo nombre

| ID | Nombre | EsActivo | MarcaUnica |
|---|---|---|---|
| 1 | Samsung | SI | Samsung |
| 2 | Apple | SI | Apple |
| 3 | Xiaomi | SI | Xiaomi |
| 4 | Saiya | NO | Saiya |
| 5 | Batri | SI | Batri |
| 6 | iGoma | SI | iGoma |
| 7 | SpaceX | NO | SpaceX |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarMarca | consultarMarcasPorFiltro | consultarMarcasPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la marca | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las marcas | No | No | - | No | No | - | - | Si | Requerido | Filtro | No mostrar |
| Nombre | Nombre del fabricante de los productos | No | Alfanumérico | Si | 2 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar |
| EsActivo | Variable booleana que define si una marca específica sigue siendo usada en la empresa | No | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO y es ingresado por el administrador; al pasar a NO la marca se inhabilita pero se conserva su historial | No | No | - | No | No | - | No | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| MarcaUnica | Combinación única que indica que no puede existir más de una marca con el mismo nombre | Nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarMarca | Permite ingresar una nueva marca en el catálogo general del sistema | datos | Marca | Contiene la información requerida para registrar la marca | Marca | Objeto de la marca registrada con su nombre y estado correspondiente | P-MAR-001 | Asegurar que el id de marca sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-MAR-002 | Asegurar que el nombre de la marca sea único e irrepetible | Generar una excepción indicando que ya existe una marca con ese nombre | Detener operación |
|  |  |  |  |  |  |  | P-MAR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarMarcasPorFiltro | Permite buscar, listar y filtrar el catálogo de marcas por nombre, identificador ID o estado | filtro | Marca | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Marca> | Contiene la lista de marcas que cumplen con las condiciones del filtro enviado | P-MAR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar una nueva marca | Permite ingresar una nueva marca en el catálogo del sistema | Marca | Datos de la nueva marca | Corresponde al nombre comercial y estado de actividad de la marca | P-MAR-001 | Asegurar que el id de marca sea único e irrepetible |  | Marca registrada |  |
|  |  |  |  |  |  | P-MAR-002 | Asegurar que el nombre de la marca sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-MAR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar marca por filtro | Permite buscar una marca por un criterio específico | Marca | Datos de la marca(Id, Nombre y esActivo) | Los parámetros de búsqueda ingresados por el usuario para filtrar la marca | P-MAR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Marcas encontradas |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-MAR-001 | Asegurar que el id de marca sea único e irrepetible | Marca |
| P-MAR-002 | Asegurar que el nombre de la marca sea único e irrepetible | Marca |
| P-MAR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Marca |

[↑ Volver al índice](#objetos-de-dominio)

---

## Motivo

**Descripción:** Representa la razón por la que un cliente solicita devolver un producto.  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único del motivo
- **Nombre**: Nombre que representa el motivo de devolución
- **MotivoUnico**: Combinación única que indica que no puede existir más de una motivo con el mismo nombre

| ID | Nombre | MotivoUnico |
|---|---|---|
| 1 | Garantía | Garantía |
| 2 | Cambio de opinión | Cambio de opinión |
| 3 | Producto incorrecto | Producto incorrecto |
| 4 | Referencia incorrecta | Referencia incorrecta |
| 5 | Otro | Otro |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarPorFiltroMotivos | consultarPorFiltroMotivos |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del motivo | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no repetirse en los distintos id's de los motivos | No | No | - | No | No | - | - | Si | Filtro | No Mostrar |
| Nombre | Nombre que representa el motivo de devolución | No | Texto | Si | 4 | 40 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| MotivoUnico | Combinación única que indica que no puede existir más de una motivo con el mismo nombre | Nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarPorFiltroMotivos | Permite consultar la información por un filtro específico de los motivos registrados en el sistema | filtro | Motivo | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Motivo> | Contiene la lista de motivos registrados en el sistema que cumplen con las condicioens del filtro enviado | P-MOT-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Informar con un mensaje de error si ocurre un fallo al recuperar la información | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Consultar los motivos por filtro | Permite consultar la información los motivos registrados en el sistema mediante un filtro específico | Motivo | Filtros de los motivos | Contiene la lista de motivos registrados en el sistema | P-MOT-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Motivos encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-MOT-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Motivo |

[↑ Volver al índice](#objetos-de-dominio)

---

## TipoDocumento

**Descripción:** Representa el tipo de documento de identidad de una persona  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único del documento
- **Tipo**: Representa el nombre del tipo de documento de identidad de una persona
- **DocumentoUnico**: Combinación única que representa que no puede existir un documento con un mismo nombre

| ID | Tipo | DocumentoUnico |
|---|---|---|
| 1 | Cédula de ciudadanía | Cédula de ciudadanía |
| 2 | Cédula de extranjería | Cédula de extranjería |
| 3 | Tarjeta de identidad | Tarjeta de identidad |
| 4 | Pasaporte | Pasaporte |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarDocumentosPorFiltro | consultarDocumentosPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del documento | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no repetirse en los distintos id's de documentos | No | No | - | No | No | - | - | Si | Filtro | No mostrar |
| Tipo | Representa el nombre del tipo de documento de identidad de una persona | No | Alfanumerico | Si | 9 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| DocumentoUnico | Combinación única que representa que no puede existir un documento con un mismo nombre | Tipo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarDocumentosPorFiltro | Permite consultar los clientes que cumplen con los criterios de búsqueda enviados | filtro | Cliente | Contiene los parámetros o criterios de consulta enviados para filtrar la búsqueda | Lista<TipoDocumento> | Contiene la lista de clientes que cumplen con las condiciones del filtro enviado | P-DOC-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Consultar documentos por filtro | Permite buscar, listar y filtrar los tipos documentos según los criterios de búsqueda enviados | Documento | Filtros de los tipos de documentos | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-DOC-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Documentos encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-DOC-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | TipoDocumento |

[↑ Volver al índice](#objetos-de-dominio)

---

## Categoria

**Descripción:** Representa la clasificación a la que pertenece un producto dentro del catálogo.  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único de la categoría
- **Nombre**: Nombre de la clasificación de productos
- **CategoriaPadre**: Identifica la categoría principal o superior a la que pertenece la clasificación correspondiente
- **Nivel**: Indica el nivel de profundidad jerárquica de la categoría dentro de la estructura del catálogo
- **CategoriaUnica**: Combinación única que indica que no puede existir más de una categoría con el mismo nombre y perteneciendo a la misma categoríaPadre

| ID | Nombre | CategoriaPadre | Nivel | CategoriaUnica |
|---|---|---|---|---|
| 1 | Accesorios |  | 1 | Accesorios \|\| |
| 2 | Estuches/Fundas | Accesorios | 2 | Estuches/Fundas \|\| Accesorios |
| 3 | Estuches Tablets | Estuches/Fundas | 3 | Estuches Tablets \|\| Estuches/Fundas |
| 4 | Estuches iPad | Estuches Tablets | 4 | Estuches iPad \|\| Estuches Tablets |
| 5 | Estuches Lenovo | Estuches Tablets | 4 | Estuches Lenovo \|\| Estuches Tablets |
| 6 | Estuches Samsung | Estuches Tablets | 4 | Estuches Samsung \|\| Estuches Tablets |
| 7 | Estuches Huawei | Estuches Tablets | 4 | Estuches Huawei \|\| Estuches Tablets |
| 8 | Estuches Xiaomi | Estuches Tablets | 4 | Estuches Xiaomi \|\| Estuches Tablets |
| 9 | Estuches Celulares | Estuches/Fundas | 3 | Estuches Celulares \|\| Estuches/Fundas |
| 10 | Estuches iPhone | Estuches Celulares | 4 | Estuches iPhone \|\| Estuches Celulares |
| 11 | Estuches Samsung | Estuches Celulares | 4 | Estuches Samsung \|\| Estuches Celulares |
| 12 | Estuches Xiaomi | Estuches Celulares | 4 | Estuches Xiaomi \|\| Estuches Celulares |
| 13 | Estuches Huawei | Estuches Celulares | 4 | Estuches Huawei \|\| Estuches Celulares |
| 14 | Estuches Motorola | Estuches Celulares | 4 | Estuches Motorola \|\| Estuches Celulares |
| 15 | Estuches Oppo | Estuches Celulares | 4 | Estuches Oppo \|\| Estuches Celulares |
| 16 | Estuches Tecno | Estuches Celulares | 4 | Estuches Tecno \|\| Estuches Celulares |
| 17 | Fundas Portatiles | Estuches/Fundas | 3 | Fundas Portatiles \|\| Estuches/Fundas |
| 18 | Fundas Apple | Fundas Portatiles | 4 | Fundas Apple \|\| Fundas Portatiles |
| 19 | Fundas Lenovo | Fundas Portatiles | 4 | Fundas Lenovo \|\| Fundas Portatiles |
| 20 | Fundas HP | Fundas Portatiles | 4 | Fundas HP \|\| Fundas Portatiles |
| 21 | Fundas Asus | Fundas Portatiles | 4 | Fundas Asus \|\| Fundas Portatiles |
| 22 | Fundas Dell | Fundas Portatiles | 4 | Fundas Dell \|\| Fundas Portatiles |
| 23 | Fundas Samsung | Fundas Portatiles | 4 | Fundas Samsung \|\| Fundas Portatiles |
| 24 | Vidrios Templados | Accesorios | 2 | Vidrios Templados \|\| Accesorios |
| 25 | Vidrios Tablets | Vidrios Templados | 3 | Vidrios Tablets \|\| Vidrios Templados |
| 26 | Vidrios iPad | Vidrios Tablets | 4 | Vidrios iPad \|\| Vidrios Tablets |
| 27 | Vidrios Lenovo | Vidrios Tablets | 4 | Vidrios Lenovo \|\| Vidrios Tablets |
| 28 | Vidrios Samsung | Vidrios Tablets | 4 | Vidrios Samsung \|\| Vidrios Tablets |
| 29 | Vidrios Huawei | Vidrios Tablets | 4 | Vidrios Huawei \|\| Vidrios Tablets |
| 30 | Vidrios Xiaomi | Vidrios Tablets | 4 | Vidrios Xiaomi \|\| Vidrios Tablets |
| 31 | Vidrios Celulares | Vidrios Templados | 3 | Vidrios Celulares \|\| Vidrios Templados |
| 32 | Vidrios iPhone | Vidrios Celulares | 4 | Vidrios iPhone \|\| Vidrios Celulares |
| 33 | Vidrios Samsung | Vidrios Celulares | 4 | Vidrios Samsung \|\| Vidrios Celulares |
| 34 | Vidrios Xiaomi | Vidrios Celulares | 4 | Vidrios Xiaomi \|\| Vidrios Celulares |
| 35 | Vidrios Huawei | Vidrios Celulares | 4 | Vidrios Huawei \|\| Vidrios Celulares |
| 36 | Vidrios Motorola | Vidrios Celulares | 4 | Vidrios Motorola \|\| Vidrios Celulares |
| 37 | Vidrios Oppo | Vidrios Celulares | 4 | Vidrios Oppo \|\| Vidrios Celulares |
| 38 | Vidrios Tecno | Vidrios Celulares | 4 | Vidrios Tecno \|\| Vidrios Celulares |
| 39 | Cables |  | 1 | Cables \|\| |
| 40 | Cables Tipo C-Tipo C | Cables | 2 | Cables Tipo C-Tipo C \|\| Cables |
| 41 | Cables Tipo C-iPhone | Cables | 2 | Cables Tipo C-iPhone \|\| Cables |
| 42 | Cables USB- Tipo C | Cables | 2 | Cables USB- Tipo C \|\| Cables |
| 43 | Cables USB - iPhone | Cables | 2 | Cables USB - iPhone \|\| Cables |
| 44 | Cargadores |  | 1 | Cargadores \|\| |
| 45 | Cargadores Apple | Cargadores | 2 | Cargadores Apple \|\| Cargadores |
| 46 | Cargadores Samsung | Cargadores | 2 | Cargadores Samsung \|\| Cargadores |
| 47 | Cargadores Xiaomi | Cargadores | 2 | Cargadores Xiaomi \|\| Cargadores |
| 48 | Cargadores Genéricos | Cargadores | 2 | Cargadores Genéricos \|\| Cargadores |
| 49 | Audífonos |  | 1 | Audífonos \|\| |
| 50 | Audífonos Inalámbricos | Audífonos | 2 | Audífonos Inalámbricos \|\| Audífonos |
| 51 | Diademas | Audífonos | 2 | Diademas \|\| Audífonos |
| 52 | Audifonos Cable | Audífonos | 2 | Audifonos Cable \|\| Audífonos |
| 53 | Audifonos Aux | Audífonos | 2 | Audifonos Aux \|\| Audífonos |
| 54 | Audifonos Tipo C | Audífonos | 2 | Audifonos Tipo C \|\| Audífonos |
| 55 | Audifonos iPhone | Audífonos | 2 | Audifonos iPhone \|\| Audífonos |
| 56 | Power Banks |  | 1 | Power Banks \|\| |
| 57 | Power Banks 5.000 mAh | Power Banks | 2 | Power Banks 5.000 mAh \|\| Power Banks |
| 58 | Power Banks 10.000 mAh | Power Banks | 2 | Power Banks 10.000 mAh \|\| Power Banks |
| 59 | Power Banks 20.000 mAh | Power Banks | 2 | Power Banks 20.000 mAh \|\| Power Banks |
| 60 | Power Banks 30.000 mAh | Power Banks | 2 | Power Banks 30.000 mAh \|\| Power Banks |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarCategoria | consultarCategoriasPorFiltro | consultarCategoriasPorFiltro | modificarCategoria | modificarCategoria | eliminarCategoria |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la categoría | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las categorías | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable | Requerido |
| Nombre | Nombre de la clasificación de productos | No | Alfanumérico | Si | 2 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | Requerido | Modificable | No Requerido |
| CategoriaPadre | Identifica la categoría principal o superior a la que pertenece la clasificación correspondiente | No | Alfanumérico | No | 2 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | Vacio | No | No requerido | Filtro | Mostrar | No requerido | Modificable | No Requerido |
| Nivel | Indica el nivel de profundidad jerárquica de la categoría dentro de la estructura del catálogo | No | Numérico Entero | Si | - | - | - | - | 1 | - | - | Se calcula a partir de la profundidad de CategoriaPadre + 1; el primer nivel es 1 | Si | No | - | No | No | - | - | No | No requerido | Filtro | No Mostrar | No Requerido | No modificable | No Requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| CategoriaUnica | Combinación única que indica que no puede existir más de una categoría con el mismo nombre y perteneciendo a la misma categoríaPadre | Nombre |
|  |  | CategoriaPadre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarCategoria | Permite registrar una nueva categoría en el sistema | datos | Categoria | Contiene la información requerida para registrar la categoría | Categoria | Objeto de la categoría registrada con su identificador ID asignado, nombre, su categoría padre  y nivel  correspondientes | P-CAT-001 | Asegurar que el id de categoría debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-CAT-002 | Asegurar que el campo nombre de categoría debe ser único e irrepetible en su respectivo nivel de categoría padre | Generar una excepción indicando que ya existe una categoría con ese mismo nombre en ese mismo nivel | Detener operación |
|  |  |  |  |  |  |  | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarCategoriasPorFiltro | Permite buscar, listar y filtrar las categorías según los criterios de búsqueda enviados, ya sea id, nombre, categoriapadre o nivel | filtro | Categoria | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Categoria> | Contiene la lista de categorías que cumplen con las condiciones del filtro enviado | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarCategoria | Permite actualizar la información de una categoría existente | id | UUID | Tiene el identificador único de la categoría a modificar y la nueva información requerida para modificar la categoría existente | Categoria | Objeto de la categoría con su información actualizada | P-CAT-002 | Asegurar que el campo nombre de categoría debe ser único e irrepetible en su respectivo nivel de categoría padre | Generar una excepción indicando que ya existe una categoría con ese mismo nombre en ese mismo nivel | Detener operación |
|  |  | datos | Categoria |  |  |  | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-CAT-004 | Asegurar que no se asigne como categoría padre a la misma categoría o a cualquier subcategoría que dependa de ella | Generar una excepción indicando que no se puede asignar como categoría padre a sí misma ni a una de sus subcategorías | Detener operación |
| eliminarCategoria | Permite eliminar una categoría si no posee ningun objeto de dominio dentro de ella | id | UUID | Contiene el identificador único de la categoría que se desea eliminar |  |  | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-CAT-005 | Asegurar que la categoría no tenga ningún producto o categoría dependiendo de ella | Generar una excepción indicando al usuario que un producto o categoría está presente dentro de la misma | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar una nueva categoría | Permite registrar una nueva categoría en el sistema | Categoria | Datos de la nueva categoría | Contiene la información requerida para registrar la categoría | P-CAT-001 | Asegurar que el id de categoría debe ser único e irrepetible |  | Categoria registrada |  |
|  |  |  |  |  |  | P-CAT-002 | Asegurar que el campo nombre de categoría debe ser único e irrepetible en su respectivo nivel de categoría padre |  |  |  |
|  |  |  |  |  |  | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar categorías por filtro | Permite buscar, listar y filtrar las categorías según los criterios de búsqueda enviados | Categoria | Filtros de las categorías | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Categorias encontradas |  |
| Administrador | Modificar una categoría | Permite actualizar la información de una categoría existente | Categoria | Datos de la categoría a modificar | Tiene el identificador único de la categoría a modificar y la nueva información | P-CAT-002 | Asegurar que el campo nombre de categoría debe ser único e irrepetible en su respectivo nivel de categoría padre |  | Categoria modificada |  |
|  |  |  |  |  |  | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
|  |  |  |  |  |  | P-CAT-004 | Asegurar que no se asigne como categoría padre a la misma categoría o a cualquier subcategoría que dependa de ella |  |  |  |
| Administrador | Eliminar Categoria | Permite eliminar una categoría del catálogo del sistema | Categoria | Datos categoría(id) | Identificador único de la categoría que se desea retirar o inactivar | P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Categoria eliminada |  |
|  |  |  |  |  |  | P-CAT-005 | Asegurar que la categoría no tenga ningún producto o categoría dependiendo de ella |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CAT-001 | Asegurar que el id de categoría debe ser único e irrepetible | Categoria |
| P-CAT-002 | Asegurar que el campo nombre de categoría debe ser único e irrepetible en su respectivo nivel de categoría padre | Categoria |
| P-CAT-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Categoria |
| P-CAT-004 | Asegurar que no se asigne como categoría padre a la misma categoría o a cualquier subcategoría que dependa de ella | Categoria |
| P-CAT-005 | Asegurar que la categoría no tenga ningún producto o categoría dependiendo de ella | Categoria |

[↑ Volver al índice](#objetos-de-dominio)

---

## Prefijo

**Descripción:** Representa el código de marcado telefónico asociado a un país para el registro de números de contacto  
**Línea de vida:** 1

### Muestreo de datos

- **ID**: Identificador único del Prefijo
- **Código**: Representa el código indicativo internacional de marcado telefónico
- **PrefijoUnico**: Combinación única que representa que no puede existir un código de prefijo igual a otro

| ID | Código | PrefijoUnico |
|---|---|---|
| 1 | +57 | +57 |
| 2 | +32 | +32 |
| 3 | +1 | +1 |
| 4 | +52 | +52 |
| 5 | +54 | +54 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarPrefijosPorFiltro | consultarPrefijosPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del Prefijo | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no repetirse en los distintos id's de de los prefijos | No | No | - | No | No | - | - | Si | Filtro | No Mostrar |
| Código | Representa el código indicativo internacional de marcado telefónico | No | Alfanumerico | Si | 2 | 8 | - | - | - | - | Formato válido de prefijos | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| PrefijoUnico | Combinación única que representa que no puede existir un código de prefijo igual a otro | Código |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarPrefijosPorFiltro | Permite consultar la información detallada de los prefijos registrados en el sistema | filtro | Prefijo | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Prefijo> | Contiene la lista de categorías que cumplen con las condiciones del filtro enviado | P-PRE-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/  Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador / Vendedor | Buscar prefijo por filtro | Permite buscar un prefijo determinado por un criterio específico (nombre, id) | Prefijo | Filtros de los prefijos | Los parámetros de búsqueda ingresados por el usuario para filtrar un prefijo | P-PRE-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Prefijos encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PRE-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Prefijo |

[↑ Volver al índice](#objetos-de-dominio)

---

## Persona

**Descripción:** Representa a un individuo en el sistema con sus datos generales de identificación  para registrarse en el sistema  
**Línea de vida:** 2

### Muestreo de datos

- **ID**: Identificador único del empleado
- **TipoDocumento**: Representa el tipo de documento de identidad de la persona
- **Prefijo**: Representa el código indicativo internacional de marcado telefónico asociado al teléfono de la persona
- **NumeroDocumento**: Representa el número del documento de identidad de la persona
- **Telefono**: Número de contacto de la persona
- **Nombre**: Representa el nombre de la persona
- **Apellido**: Representa el apellido de la persona
- **Correo**: Correo electrónico de las personas
- **TelefonoConfirmado**: Variable booleana que define si el teléfono de la persona está confirmado o no
- **CorreoConfirmado**: Variable booleana que define si el correo electrónico de la persona está confirmado o no
- **DocumentoPersona**: Combinación única que indica que no puede existir más de un empleado con el mismo número de documento
- **TelefonoPersona**: Combinación única que indica que no puede existir más de un empleado con el mismo teléfono
- **CorreoPersona**: Combinación única que indica que no puede existir más de un empleado con el mismo correo

| ID | TipoDocumento | Prefijo | NumeroDocumento | Telefono | Nombre | Apellido | Correo | TelefonoConfirmado | CorreoConfirmado | DocumentoPersona | TelefonoPersona | CorreoPersona |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | Cédula de ciudadanía | +57 | 1027661773 | 3001234568 | Carlos Andrés | Riaño | carlos.gomez@gmail.com | SI | NO | 1027661773 | 3001234568 | carlos.gomez@gmail.com |
| 2 | Cédula de extranjería | +32 | 123456789 | 3001234569 | Mariana | Jiménez | mariana.lopez@gmail.com | SI | SI | 123456789 | 3001234569 | mariana.lopez@gmail.com |
| 3 | Tarjeta de identidad | +1 | 900123456-7 | 3001234571 | Valentina | Vélez | valentina.ruiz@gmail.com | NO | SI | 900123456-7 | 3001234571 | valentina.ruiz@gmail.com |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarPersona | consultarPersonasPorFiltro | consultarPersonasPorFiltro | modificarPersona | modificarPersona | eliminarPersona |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del empleado | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los clientes registrados naturales | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable | Requerido |
| TipoDocumento | Representa el tipo de documento de identidad de la persona | No | TipoDocumento | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Prefijo | Representa el código indicativo internacional de marcado telefónico asociado al teléfono de la persona | No | Prefijo | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | No filtro | Mostrar | No Requerido | Modificable | No requerido |
| NumeroDocumento | Representa el número del documento de identidad de la persona | No | Alfanumérico | Si | 3 | 20 | - | - | - | - | Formato de documento correspondiente válido 1.207.661.773 | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | Si | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Telefono | Número de contacto de la persona | No | Alfanumérico | Si | 7 | 15 | - | - | - | - | Formato de número telefónico correspondiente válido (+57) 3158185857 | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque, solo se aceptan dígitos | No | No | - | Si | Si | Si | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Nombre | Representa el nombre de la persona | No | Alfanumérico | Si | 2 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Apellido | Representa el apellido de la persona | No | Alfanumérico | Si | 2 | 100 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Correo | Correo electrónico de las personas | No | Alfanumérico | Si | 6 | 254 | - | - | - | - | Formato válido de correo electrónico | Debe contener únicamente números y corresponder a un número telefónico móvil o fijo colombiano válido | No | No | - | Si | Si | Si | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| TelefonoConfirmado | Variable booleana que define si el teléfono de la persona está confirmado o no | No | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO, pasa a SI únicamente tras validar el correo con el cliente o empleado, por medio de un mensaje o un vinculo | No | No | - | No | No | - | No | Si | No Requerido | No filtro | No Mostrar | No Requerido | No modificable | No requerido |
| CorreoConfirmado | Variable booleana que define si el correo electrónico de la persona está confirmado o no | No | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO; pasa a SI únicamente tras validar el teléfono con el cliente o empleado, por medio de un mensaje o un vinculo | No | No | - | No | No | - | No | Si | No Requerido | No filtro | No Mostrar | No requerido | No modificable | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| DocumentoPersona | Combinación única que indica que no puede existir más de un empleado con el mismo número de documento | NumeroDocumento |
| TelefonoPersona | Combinación única que indica que no puede existir más de un empleado con el mismo teléfono | Telefono |
| CorreoPersona | Combinación única que indica que no puede existir más de un empleado con el mismo correo | Correo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarPersona | Permite registrar una nueva persona en el sistema | datos | Persona | Contiene la información requerida para registrar la persona correspondiente | Persona | Objeto de la persona con su identificador ID asignado, nombre, apellido, teléfono y demás atributos | P-PER-001 | Asegurar que el id de la persona sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-PER-002 | Asegurar que el campo NumeroDocumento de la persona sea único e irrepetible | Generar una excepción indicando que ya existe una persona con ese mismo Documento | Detener operación |
|  |  |  |  |  |  |  | P-PER-003 | Asegurar que el campo Telefono de la persona sea único e irrepetible | Generar una excepción indicando que ya existe una persona con ese mismo Telefono | Detener operación |
|  |  |  |  |  |  |  | P-PER-004 | Asegurar que el campo Correo de la persona sea único e irrepetible | Generar una excepción indicando que ya existe una persona con ese mismo Correo | Detener operación |
|  |  |  |  |  |  |  | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-PER-007 | Asegurar que la persona tiene la opcion de escoger cualquier tipo de documento a excepción del NIT | Generar una excepción indicando que el nit no está disponible para registrar persona natural | Detener operación |
| consultarPersonasPorFiltro | Permite buscar, listar y filtrar las personas según los criterios de búsqueda enviados | filtro | Persona | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Persona> | Contiene la lista de las personas que cumplen con las condiciones del filtro enviado | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarPersona | Permite actualizar la información de una persona existente | id | UUID | Tiene el identificador único de una persona a modificar y la nueva información correspondiente | Persona | Objeto de la persona con su información actualizada | P-PER-002 | Asegurar que el campo NumeroDocumento de la persona sea único e irrepetible | Generar una excepción indicando que ya existe una persona con ese mismo Documento | Detener operación |
|  |  |  |  |  |  |  | P-PER-003 | Asegurar que el campo Telefono de la persona sea único e irrepetible | Generar una excepción indicando que ya existe una persona con ese mismo Telefono | Detener operación |
|  |  | datos | Persona |  |  |  | P-PER-004 | Asegurar que el campo Correo de la persona sea único e irrepetible | Generar una excepción indicando que ya existe una persona con ese mismo Correo | Detener operación |
|  |  |  |  |  |  |  | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| eliminarPersona | Permite eliminar una persona eliminando la trazabilidad de su historial | id | UUID | Contiene el identificador único de la persona que se desea eliminar |  |  | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-PER-006 | Asegurar que persona no esté siendo utilizado dentro de otro objeto de dominio | Generar una excepción indicando al usuario que el objeto de dominio está presente dentro de otro objeto | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar una nueva persona | Permite registrar una nueva persona en el sistema | Persona | Datos de la nueva persona | Contiene la información requerida para registrar la persona | P-PER-001 | Asegurar que el id de la persona sea único e irrepetible |  | Persona registrada |  |
|  |  |  |  |  |  | P-PER-002 | Asegurar que el campo NumeroDocumento de la persona sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PER-003 | Asegurar que el campo Telefono de la persona sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PER-004 | Asegurar que el campo Correo de la persona sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
|  |  |  |  |  |  | P-PER-007 | Asegurar que la persona tiene la opcion de escoger cualquier tipo de documento a excepción del NIT |  |  |  |
| Administrador/Vendedor | Consultar personas por filtro | Permite buscar, listar y filtrar las personas según los criterios de búsqueda enviados | Persona | Filtros de Persona | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Personas encontradas |  |
| Administrador | Modificar una persona | Permite actualizar la información de una persona existente | Persona | Datos de la persona a modificar | Tiene el identificador único de la persona a modificar y la nueva información | P-PER-002 | Asegurar que el campo NumeroDocumento de la persona sea único e irrepetible |  | Persona modificada |  |
|  |  |  |  |  |  | P-PER-003 | Asegurar que el campo Telefono de la persona sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PER-004 | Asegurar que el campo Correo de la persona sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador | Eliminar una persona | Permite eliminar una persona eliminando la trazabilidad de su historial | Persona | Identificador de la persona a eliminar | Contiene el identificador único de la persona que se desea eliminar | P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Persona eliminada |  |
|  |  |  |  |  |  | P-PER-006 | Asegurar que persona no esté siendo utilizado dentro de otro objeto de dominio |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PER-001 | Asegurar que el id de la persona sea único e irrepetible | Persona |
| P-PER-002 | Asegurar que el campo NumeroDocumento de la persona sea único e irrepetible | Persona |
| P-PER-003 | Asegurar que el campo Telefono de la persona sea único e irrepetible | Persona |
| P-PER-004 | Asegurar que el campo Correo de la persona sea único e irrepetible | Persona |
| P-PER-005 | Asegurar que los datos requeridos de la persona sean válidos en tipo de dato, longitud, obligatoriedad y formato | Persona |
| P-PER-006 | Asegurar que persona no esté siendo utilizado dentro de otro objeto de dominio | Persona |
| P-PER-007 | Asegurar que la persona tiene la opcion de escoger cualquier tipo de documento a excepción del NIT | Persona |

[↑ Volver al índice](#objetos-de-dominio)

---

## Producto

**Descripción:** Representa un artículo del catálogo general del negocio, independiente de la sede en la que se encuentre.  
**Línea de vida:** 2

### Muestreo de datos

- **ID**: Identificador único del producto
- **Marca**: Marca a la que pertenece el producto
- **Categoria**: Categoría a la que pertenece el producto
- **Modelo**: Modelo o referencia única del producto
- **Nombre**: Nombre del accesorio dentro del catálogo general
- **Descripción**: Descripción general del accesorio
- **ModeloUnico**: Combinación única que indica que no puede existir más de un producto con el mismo modelo

| ID | Marca | Categoria | Modelo | Nombre | Descripción | ModeloUnico |
|---|---|---|---|---|---|---|
| 1 | Apple | Estuches iPhone \|\| Estuches Celulares | LWFIP14 | Funda Silicona iPhone 14 | Funda de silicona suave con acabado mate | LWFIP14 |
| 2 | Apple | Vidrios iPhone \|\| Vidrios Celulares | VDIP13 | Vidrio Templado iPhone 13 | Protector de pantalla de vidrio templado antiespías | VDIP13 |
| 3 | Apple | Cargadores Apple \|\| Cargadores | TPCIP35w | Cargador Rápido 35W USB-C | Cargador con cable carga rápida | TPCIP35w |
| 4 | Xiaomi | Audífonos Inalámbricos \|\| Audífonos | AirDots 2 | Audífonos Bluetooth Buds | Audífonos inalámbricos con estuche de carga | AirDots 2 |
| 5 | Samsung | Vidrios Samsung \|\| Vidrios Celulares | VDA12 | Vidrio Templado Samsung A12 | Protector de pantalla de vidrio templado | VDA12 |
| 6 | Batri | Cables Tipo C-Tipo C \|\| Cables | CU16 | Cable USB-C a USB-C 1m | Cable de carga y transferencia de datos | CU16 |
| 7 | iGoma | Power Banks 10.000 mAh \|\| Power Banks | IG-029 | Power Bank 10000mAh | Batería portátil de carga rápida | IG-029 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarProducto | consultarProductosPorFiltro | consultarProductosPorFiltro | modificarProducto | modificarProducto |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del producto | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los productos | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable |
| Marca | Marca a la que pertenece el producto | No | Marca | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | No Modificable |
| Categoria | Categoría a la que pertenece el producto | No | Categoria | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable |
| Modelo | Modelo o referencia única del producto | No | Alfanumérico | Si | 2 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable |
| Nombre | Nombre del accesorio dentro del catálogo general | No | Alfanumérico | Si | 2 | 60 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable |
| Descripción | Descripción general del accesorio | No | Alfanumérico | Si | 10 | 500 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | No filtro | No Mostrar | No Requerido | Modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| ModeloUnico | Combinación única que indica que no puede existir más de un producto con el mismo modelo | Modelo |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarProducto | Permite registrar un nuevo producto en el sistema | datos | Producto | Contiene la información requerida para registrar el producto | Producto | Objeto del producto registrado con su identificador ID asignado y demas atributos correspondientes | P-PRO-001 | Asegurar que el id de producto debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-PRO-002 | Asegurar que el campo Modelo de producto debe ser único e irrepetible | Generar una excepción indicando que ya existe un producto con ese mismo Modelo | Detener operación |
|  |  |  |  |  |  |  | P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarProductosPorFiltro | Permite buscar, listar y filtrar los productos según los criterios de búsqueda enviados | filtro | Producto | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Producto> | Contiene la lista de productos que cumplen con las condiciones del filtro enviado | P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarProducto | Permite actualizar la información de un producto existente | id | UUID | Tiene el identificador único del producto a modificar y la nueva información | Producto | Objeto del producto con su información actualizada | P-PRO-002 | Asegurar que el campo Modelo de producto debe ser único e irrepetible | Generar una excepción indicando que ya existe un producto con ese mismo Modelo | Detener operación |
|  |  | datos | Producto |  |  |  | P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo producto | Permite registrar un nuevo producto en el sistema | Producto | Datos del nuevo producto | Contiene la información requerida para registrar el producto | P-PRO-001 | Asegurar que el id de producto debe ser único e irrepetible |  | Producto registrado |  |
|  |  |  |  |  |  | P-PRO-002 | Asegurar que el campo Modelo de producto debe ser único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar productos por filtro | Permite buscar, listar y filtrar los productos según los criterios de búsqueda enviados | Producto | Filtros de los productos | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Productos encontrados |  |
| Administrador | Modificar un producto | Permite actualizar la información de un producto existente | Producto | Datos del producto a modificar | Tiene el identificador único del producto a modificar y la nueva información | P-PRO-002 | Asegurar que el campo Modelo de producto debe ser único e irrepetible |  | Producto modificado |  |
|  |  |  |  |  |  | P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PRO-001 | Asegurar que el id de producto debe ser único e irrepetible | Producto |
| P-PRO-002 | Asegurar que el campo Modelo de producto debe ser único e irrepetible | Producto |
| P-PRO-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Producto |

[↑ Volver al índice](#objetos-de-dominio)

---

## Departamento

**Descripción:** Representa el departamento o división administrativa al que pertenece una ciudad dentro de un país.  
**Línea de vida:** 2

### Muestreo de datos

- **ID**: Identificador único del departamento
- **Pais**: País al que pertenece el departamento
- **Nombre**: Nombre oficial del departamento que contiene las distintas sedes del negocio
- **PaisDepartamento**: Combinación única que indica que no puede existir más de un departamento con el mismo nombre en un mismo país

| ID | Pais | Nombre | PaisDepartamento |
|---|---|---|---|
| 1 | Colombia | Antioquia | Colombia + Antioquia |
| 2 | Colombia | Cundinamarca | Colombia + Cundinamarca |
| 3 | Ecuador | Pichincha | Ecuador + Pichincha |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarDepartamentosPorFiltro | consultarDepartamentosPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del departamento | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los departamentos | No | No | - | No | No | - | - | Si | Filtro | No Mostrar |
| Pais | País al que pertenece el departamento | No | Pais | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Filtro | Mostrar |
| Nombre | Nombre oficial del departamento que contiene las distintas sedes del negocio | No | Alfanumérico | Si | 2 | 100 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| PaisDepartamento | Combinación única que indica que no puede existir más de un departamento con el mismo nombre en un mismo país | Pais |
|  |  | Nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarDepartamentosPorFiltro | Permite buscar, listar y filtrar los departamentos según los criterios de búsqueda enviados | filtro | Departamento | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Departamento> | Contiene la lista de departamentos que cumplen con las condiciones del filtro enviado | P-DEP-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Consultar departamentos por filtro | Permite buscar, listar y filtrar los departamentos según los criterios de búsqueda enviados | Departamento | Filtros de los departamentos | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-DEP-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Departamentos encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-DEP-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Departamento |

[↑ Volver al índice](#objetos-de-dominio)

---

## ClienteRegistrado

**Descripción:** Representa al cliente cuyos datos de identificación y contacto han sido registrados en el sistema  
**Línea de vida:** 2

### Muestreo de datos

- **ID**: Identificador único del cliente registrado
- **Cliente**: Representa a la persona cuyos datos de identificación y contacto van a ser registrados en el sistema como cliente
- **ClienteRegistradoUnico**: Combinación única que indica que no puede existir más de un cliente registrado que pueda ser el mismo cliente

| ID | Cliente | ClienteRegistradoUnico |
|---|---|---|
| 1 | 1 | 1 |
| 2 | 2 | 2 |
| 3 | 3 | 3 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarClienteRegistrado | consultarClientesRegistradosPorFiltro | consultarClientesRegistradosPorFiltro | eliminarClienteRegistrado |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del cliente registrado | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los clientes  registrados | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido |
| Cliente | Representa a la persona cuyos datos de identificación y contacto van a ser registrados en el sistema como cliente | No | Cliente | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| ClienteRegistradoUnico | Combinación única que indica que no puede existir más de un cliente registrado que pueda ser el mismo cliente | Cliente |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarClienteRegistrado | Permite registrar un nuevo cliente registrado en el sistema | datos | ClienteRegistrado | Contiene la información requerida para registrar el cliente registrado | ClienteRegistrado | Objeto del cliente registrado con su identificador ID asignado y el cliente correspondiente | P-CLR-001 | Asegurar que el id de cliente registrado debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-CLR-002 | Garantizar que el cliente a registrar no este asociado a más de un ClienteRegistrado ni a un ClienteNoRegistrado para evitar duplicación de clientes | Generar una excepción indicando que ese cliente ya se ha registrado en algún momento en el sistema | Detener operación |
|  |  |  |  |  |  |  | P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarClientesRegistradosPorFiltro | Permite buscar, listar y filtrar los clientes registrados según los criterios de búsqueda enviados | filtro | ClienteRegistrado | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<ClienteRegistrado> | Contiene la lista de clientes registrados que cumplen con las condiciones del filtro enviado | P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| eliminarClienteRegistrado | Permite eliminar un cliente eliminando todo su historial de compras y de devoluciones, solo si el cliente registrado lo desea | id | UUID | Contiene el identificador único del cliente que se desea eliminar |  |  | P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-CLR-004 | Asegurar que el cliente registrado no esté siendo utilizado dentro de ningún otro objeto de dominio | Generar una excepción indicando al usuario que el cliente registrado está siendo usado por otros tipos de clientes registrados | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo cliente registrado | Permite registrar un nuevo cliente registrado en el sistema | ClienteRegistrado | Datos del nuevo cliente registrado | Contiene la información requerida para registrar el cliente registrado | P-CLR-001 | Asegurar que el id de cliente registrado debe ser único e irrepetible |  | Cliente registrado creado |  |
|  |  |  |  |  |  | P-CLR-002 | Garantizar que el cliente a registrar no este asociado a más de un ClienteRegistrado ni a un ClienteNoRegistrado para evitar duplicación de clientes |  |  |  |
|  |  |  |  |  |  | P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar clientes registrados por filtro | Permite buscar, listar y filtrar los clientes registrados según los criterios de búsqueda enviados | ClienteRegistrado | Filtros del cliente registrado | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Clientes registrados encontrados |  |
| Administrador | Eliminar un cliente registrado | Permite eliminar un cliente registrado eliminando la trazabilidad de su historial | ClienteRegistrado | Identificador del cliente registrado | Contiene el identificador único del cliente registrado que se desea eliminar | P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Cliente registrado eliminado |  |
|  |  |  |  |  |  | P-CLR-004 | Asegurar que el cliente registrado no esté siendo utilizado dentro de ningún otro objeto de dominio |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CLR-001 | Asegurar que el id de cliente registrado debe ser único e irrepetible | ClienteRegistrado |
| P-CLR-002 | Garantizar que el cliente a registrar no este asociado a más de un ClienteRegistrado ni a un ClienteNoRegistrado para evitar duplicación de clientes | ClienteRegistrado |
| P-CLR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | ClienteRegistrado |
| P-CLR-004 | Asegurar que el cliente registrado no esté siendo utilizado dentro de ningún otro objeto de dominio | ClienteRegistrado |

[↑ Volver al índice](#objetos-de-dominio)

---

## ClienteNoRegistrado

**Descripción:** Representa a la persona que realiza una compra sin contar con un registro previo en el sistema  
**Línea de vida:** 2

### Muestreo de datos

- **ID**: Identificador único del cliente no registrado
- **Cliente**: Representa a la persona que no se desea registrar en el sistema
- **ClienteNoRegistradoUnico**: Combinación única que indica que no puede existir más de un cliente no registrado que pueda ser el mismo cliente

| ID | Cliente | ClienteNoRegistradoUnico |
|---|---|---|
| 1 | 1 | 1 |
| 2 | 4 | 4 |
| 3 | 6 | 6 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarClienteNoRegistrado | consultarClientesNoRegistradosPorFiltro | consultarClientesNoRegistradosPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del cliente no registrado | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los clientes no registrados | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Cliente | Representa a la persona que no se desea registrar en el sistema | No | Cliente | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |   |
|---|---|---|---|
| ClienteNoRegistradoUnico | Combinación única que indica que no puede existir más de un cliente no registrado que pueda ser el mismo cliente | Cliente |  |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarClienteNoRegistrado | Permite registrar un nuevo cliente no registrado en el sistema | datos | ClienteNoRegistrado | Contiene la información requerida para registrar el cliente no registrado | ClienteNoRegistrado | Objeto del cliente no registrado con su identificador ID asignado y su cliente correspondiente | P-CNR-001 | Asegurar que el id de cliente no registrado debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-CNR-002 | Garantizar que el cliente a registrar no este asociado a más de un ClienteRegistrado ni a un ClienteNoRegistrado para evitar duplicación de clientes | Generar una excepción indicando que ese cliente ya se ha registrado en algún momento en el sistema | Detener operación |
|  |  |  |  |  |  |  | P-CNR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarClientesNoRegistradosPorFiltro | Permite buscar, listar y filtrar los clientes no registrados según los criterios de búsqueda enviados | filtro | ClienteNoRegistrado | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<ClienteNoRegistrado> | Contiene la lista de clientes no registrados que cumplen con las condiciones del filtro enviado | P-CNR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo cliente no registrado | Permite registrar un nuevo cliente no registrado en el sistema | ClienteNoRegistrado | Datos del nuevo cliente no registrado | Contiene la información requerida para registrar el cliente no registrado | P-CNR-001 | Asegurar que el id de cliente no registrado debe ser único e irrepetible |  | Cliente no registrado creado |  |
|  |  |  |  |  |  | P-CNR-002 | Garantizar que el cliente a registrar no este asociado a más de un ClienteRegistrado ni a un ClienteNoRegistrado para evitar duplicación de clientes |  |  |  |
|  |  |  |  |  |  | P-CNR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar clientes no registrados por filtro | Permite buscar, listar y filtrar los clientes no registrados según los criterios de búsqueda enviados | ClienteNoRegistrado | Filtros del cliente no registrado | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-CNR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Clientes no registrados encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CNR-001 | Asegurar que el id de cliente no registrado debe ser único e irrepetible | ClienteNoRegistrado |
| P-CNR-002 | Garantizar que el cliente a registrar no este asociado a más de un ClienteRegistrado ni a un ClienteNoRegistrado para evitar duplicación de clientes | ClienteNoRegistrado |
| P-CNR-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | ClienteNoRegistrado |

[↑ Volver al índice](#objetos-de-dominio)

---

## ClienteRegistradoN

**Descripción:** Representa al cliente registrado natural en el sistema con sus datos básicos de identificación y contacto  
**Línea de vida:** 3

### Muestreo de datos

- **ID**: Identificador único del cliente registrado natural
- **ClienteRegistrado**: Referencia al cliente registrado asociado al cliente registrado natural
- **Persona**: Nombre completo de la persona asociada al cliente registrado natural
- **ClienteNaturalUnico**: Combinación única que garantiza que un mismo ClienteRegistrado no se puede asociar más de una vez a un cliente registrado natural
- **PersonaNaturalUnica**: Combinación única que representa que una misma persona no se puede asociar a más de un cliente registrado natura

| ID | ClienteRegistrado | Persona | ClienteNaturalUnico | PersonaNaturalUnica |
|---|---|---|---|---|
| 1 | 1 | 1 | 1 | 1 |
| 2 | 2 | 2 | 2 | 2 |
| 3 | 3 | 3 | 3 | 3 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarClienteRegistradoNatural | consultarClientesRegistradosNaturalesPorFiltro | consultarClientesRegistradosNaturalesPorFiltro | eliminarClienteRegistradoNatural |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del cliente registrado natural | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los clientes registrados naturales | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido |
| ClienteRegistrado | Referencia al cliente registrado asociado al cliente registrado natural | No | ClienteRegistrado | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido |
| Persona | Nombre completo de la persona asociada al cliente registrado natural | No | Persona | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| ClienteNaturalUnico | Combinación única que garantiza que un mismo ClienteRegistrado no se puede asociar más de una vez a un cliente registrado natural | ClienteRegistrado |
| PersonaNaturalUnica | Combinación única que representa que una misma persona no se puede asociar a más de un cliente registrado natura | Persona |

| Responsabilidad | Descripción | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|---|
| registrarClienteRegistradoNatural | Permite registrar un nuevo cliente registrado natural en el sistema | Permite registrar un nuevo cliente registrado natural en el sistema | datos | ClienteRegistradoNatural | Contiene la información requerida para registrar el cliente registrado natural correspondiente | ClienteRegistradoNatural | Objeto del cliente registrado natural con su identificador ID y las referencias a ClienteRegistrado y Persona | P-CRN-001 | Asegurar que el id del cliente registrado natural sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  |  | P-CRN-002 | El sistema debe garantizar que un mismo cliente registrado no  este asociado a más de un ClienteRegistradoNatural ni a un ClienteRegistradoJuridico para evitar duplicación de clientes registrados | Generar una excepción indicando que ya existe un cliente registrado natural o jurídico que se ha asociado a ese mismo ClienteRegistrado | Detener operación |
|  |  |  |  |  |  |  |  | P-CRN-003 | El sistema debe garantizar que una misma persona no esté asociada a más de un ClienteRegistradoNatural ni un empleado para evitar duplicación de personas | Generar una excepción indicando que la persona ya se encuentra asociada a otro cliente registrado natural o empleado | Detener operación |
|  |  |  |  |  |  |  |  | P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarClientesRegistradosNaturalesPorFiltro | Permite buscar, listar y filtrar los clientes registrados naturales según los criterios de búsqueda enviados | Permite buscar, listar y filtrar los clientes registrados naturales según los criterios de búsqueda enviados | filtro | ClienteRegistradoNatural | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<ClienteRegistradoNatural> | Contiene la lista de los clientes registrados naturales que cumplen con las condiciones del filtro enviado | P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| eliminarClienteRegistradoNatural | Permite eliminar un cliente registrado natural eliminando la trazabilidad de su historial, solo si el cliente lo desea |  | id | UUID | Contiene el identificador único del cliente registrado natural que se desea eliminar |  |  | P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  |  | P-CRN-005 | Asegurar que cliente no este realizando algún proceso o transacción de compra en el momento de la eliminación | Generar una exepción indicando que el cliente se encuentra realizando una transacción importante en el momento, por lo que es imposible eliminarlo instantáneamente | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo cliente registrado natural | Permite registrar un nuevo cliente registrado natural en el sistema | ClienteRegistradoNatural | Datos del nuevo cliente registrado natural | Contiene la información requerida para registrar un nuevo cliente registrado natural en el sistema | P-CRN-001 | Asegurar que el id del cliente registrado natural sea único e irrepetible |  | Cliente registrado natural creado |  |
|  |  |  |  |  |  | P-CRN-002 | El sistema debe garantizar que un mismo cliente registrado no  este asociado a más de un ClienteRegistradoNatural ni a un ClienteRegistradoJuridico para evitar duplicación de clientes registrados |  |  |  |
|  |  |  |  |  |  | P-CRN-003 | El sistema debe garantizar que una misma persona no esté asociada a más de un ClienteRegistradoNatural ni un empleado para evitar duplicación de personas |  |  |  |
|  |  |  |  |  |  | P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar clientes registrados naturales por filtro | Permite buscar, listar y filtrar los clientes registrados naturales según los criterios de búsqueda enviados | ClienteRegistradoNatural | Filtros de cliente registrado natural | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Clientes registrados naturales encontrados |  |
| Administrador | Eliminar un cliente registrado natural | Permite eliminar un cliente registrado natural eliminando la trazabilidad de su historial, solo si el cliente lo desea | ClienteRegistradoNatural | Identificador del cliente registrado natural a eliminar | Contiene el identificador único del cliente registrado natural que se desea eliminar | P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Cliente registrado natural eliminado |  |
|  |  |  |  |  |  | P-CRN-005 | Asegurar que cliente no este realizando algún proceso o transacción de compra en el momento de la eliminación |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CRN-001 | Asegurar que el id del cliente registrado natural sea único e irrepetible | ClienteRegistradoNatural |
| P-CRN-002 | El sistema debe garantizar que un mismo cliente registrado no  este asociado a más de un ClienteRegistradoNatural ni a un ClienteRegistradoJuridico para evitar duplicación de clientes registrados | ClienteRegistradoNatural |
| P-CRN-003 | El sistema debe garantizar que una misma persona no esté asociada a más de un ClienteRegistradoNatural ni un empleado para evitar duplicación de personas | ClienteRegistradoNatural |
| P-CRN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | ClienteRegistradoNatural |
| P-CRN-005 | Asegurar que cliente no este realizando algún proceso o transacción de compra en el momento de la eliminación | ClienteRegistradoNatural |

[↑ Volver al índice](#objetos-de-dominio)

---

## ClienteRegistradoJ

**Descripción:** Representa al cliente registrado Jurídico en el sistema con sus datos básicos de identificación y contacto  
**Línea de vida:** 3

### Muestreo de datos

- **ID**: Identificador único del cliente registrado jurídico
- **ClienteRegistrado**: Representa al cliente registrado asociado al cliente registrado jurídico
- **Prefijo**: Representa el código indicativo internacional de marcado telefónico
- **Telefono**: Número de contacto de un cliente registrado jurídico
- **NIT**: Representa el número del documento de un cliente registrado jurídico
- **RazónSocial**: Representa el nombre de un cliente registrado jurídico
- **Correo**: Correo electrónico de un cliente registrado jurídico
- **TelefonoConfirmado**: Variable booleana que define si el teléfono de un cliente registrado jurídico específico está confirmado o no
- **CorreoConfirmado**: Variable booleana que define si un correo de un cliente registrado jurídico específico está confirmado o no
- **TelefonoJuridicoUnico**: Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo teléfono
- **NitJuridicoUnico**: Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo NIT
- **RazonSocialUnica**: Combinación única  que indica que no puede exisitir más de un cliente registrado jurídico con la misma razón social
- **CorreoJuridicoUnico**: Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo correo
- **ClienteJuridicoUnico**: Combinación única que garantiza que un mismo ClienteRegistrado no se puede asociar más de una vez a un cliente registrado jurídico

| ID | ClienteRegistrado | Prefijo | Telefono | NIT | RazónSocial | Correo | TelefonoConfirmado | CorreoConfirmado | TelefonoJuridicoUnico | NitJuridicoUnico | RazonSocialUnica | CorreoJuridicoUnico | ClienteJuridicoUnico |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | 1 | +57 | 3001234568 | 988456256-8 | Agricultura SAS | agriculturasas@gmail.com | SI | NO | 3001234568 | 988456256-8 | Agricultura SAS | agriculturasas@gmail.com | Agricultura SAS |
| 2 | 2 | +32 | 3001234569 | 904154456-7 | Sayonara SAS | Sayonarasas@gmail.com | SI | SI | 3001234569 | 904154456-7 | Sayonara SAS | Sayonarasas@gmail.com | Sayonara SAS |
| 3 | 3 | +1 | 3001234571 | 900123456-9 | Telcel SOS | Telcelsos@gmail.com | NO | SI | 3001234571 | 900123456-9 | Telcel SOS | Telcelsos@gmail.com | Telcel SOS |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarClienteRegistradoJuridico | consultarClientesRegistradosJuridicosPorFiltro | consultarClientesRegistradosJuridicosPorFiltro | modificarClienteRegistradoJuridico | modificarClienteRegistradoJuridico | eliminarClienteRegistradoJuridico |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del cliente registrado jurídico | Si | Identificador único universal | Si | - | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los clientes registrados jurídicos | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable | Requerido |
| ClienteRegistrado | Representa al cliente registrado asociado al cliente registrado jurídico | No | ClienteRegistrado | Si | - | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | No modificable | No requerido |
| Prefijo | Número de contacto de un cliente registrado jurídico | No | Prefijo | Si | - | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | No filtro | Mostrar | No requerido | Modificable | No requerido |
| Telefono | Número de contacto de un cliente registrado jurídico | No | Alfanumérico | Si | 7 | 7 | 15 | - | - | - | - | Formato de número telefónico correspondiente válido (+57) 3158185857 | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque, solo se aceptan dígitos | No | No | - | Si | Si | Si | - | No | Requerido | Filtro | Mostrar | No requerido | Modificable | No requerido |
| NIT | Representa el número del documento de un cliente registrado jurídico | No | Alfanumérico | Si | 6 | 3 | 20 | - | - | - | - | Formato de NIT correspondiente válido 903276582-1 | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No requerido | No Modificable | No requerido |
| RazónSocial | Representa el nombre de un cliente registrado jurídico | No | Alfanumérico | Si | 2 | 7 | 50 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque, debe corresponder a la razón social del nit respectivo del cliente jurídico | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No requerido | Modificable | No requerido |
| Correo | Correo electrónico de un cliente registrado jurídico | No | Alfanumérico | Si | 6 | 2 | 254 | - | - | - | - | Formato valido de correo electrónico Saraitelsas@gmail.com | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | Si | - | No | Requerido | Filtro | Mostrar | No requerido | Modificable | No requerido |
| CorreoConfirmado | Variable booleana que define si un correo de un cliente registrado jurídico específico está confirmado o no | No | Lógico | Si | - | - | - | - | - | - | - | - | Solo admite SI o NO, pasa a SI únicamente tras validar el correo con el cliente o empleado, por medio de un mensaje o un vinculo | No | No | - | No | No | - | No | Si | No Requerido | No filtro | No Mostrar | No requerido | No modificable | No requerido |
| TelefonoConfirmado | Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo teléfono | No | Lógico | Si | - | - | - | - | - | - | - | - | Solo admite SI o NO; pasa a SI únicamente tras validar el teléfono con el cliente o empleado, por medio de un mensaje o un vinculo | No | No | - | No | No | - | No | Si | No Requerido | No Filtro | No Mostrar | No requerido | No modificable | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| TelefonoJuridicoUnico | Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo teléfono | Telefono |
| NitJuridicoUnico | Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo NIT | NIT |
| RazonSocialUnica | Combinación única  que indica que no puede exisitir más de un cliente registrado jurídico con la misma razón social | RazónSocial |
| CorreoJuridicoUnico | Combinación única que indica que no puede existir más de un cliente registrado jurídico con el mismo correo | Correo |
| ClienteJuridicoUnico | Combinación única que garantiza que un mismo ClienteRegistrado no se puede asociar más de una vez a un cliente registrado jurídico | ClienteRegistrado |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarClienteRegistradoJuridico | Permite registrar un nuevo cliente registrado jurídico en el sistema | datos | ClienteRegistradoJuridico | Contiene la información requerida para registrar el cliente registrado jurídico correspondiente | ClienteRegistradoJuridico | Objeto del cliente registrado jurídico con su identificador ID asignado, nombre, apellido, teléfono y demás atributos | P-CRJ-001 | Asegurar que el id del cliente registrado jurídico sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-CRJ-002 | Asegurar que el campo NIT del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Documento | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-003 | Asegurar que el campo Telefono del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Telefono | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-004 | Asegurar que el campo Correo del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Correo | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-005 | Asegurar que el campo RazonSocial del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con esa misma Razon social | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-006 | Garantizar que el sistema debe validar que un mismo cliente registrado no esté asociado a más de un ClienteRegistradoNatural ni a un ClienteRegistradoJuridico | Generar una excepción indicando que ya existe un cliente registrado natural o jurídico que se ha asociado a ese mismo ClienteRegistrado | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarClientesRegistradosJuridicosPorFiltro | Permite buscar, listar y filtrar los clientes registrados jurídicos según los criterios de búsqueda enviados | filtro | ClienteRegistradoJuridico | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<ClienteRegistradoJuridico> | Contiene la lista de los clientes registrados jurídicos que cumplen con las condiciones del filtro enviado | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarClienteRegistradoJuridico | Permite actualizar la información de un cliente registrado jurídico existente | id | UUID | Tiene el identificador único del cliente registrado jurídico a modificar y la nueva información | ClienteRegistradoJuridico | Objeto del cliente registrado jurídico con su información actualizada | P-CRJ-003 | Asegurar que el campo Telefono del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Telefono | Detener operación |
|  |  | datos | ClienteRegistradoJuridico |  |  |  | P-CRJ-004 | Asegurar que el campo Correo del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con ese mismo Correo | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-005 | Asegurar que el campo RazonSocial del cliente registrado jurídico sea único e irrepetible | Generar una excepción indicando que ya existe un cliente registrado con esa misma Razon social | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que el cliente registrado no existe o no puede ser modificado | Detener operación |
| eliminarClienteRegistradoJuridico | Permite eliminar un cliente registrado jurídico eliminando la trazabilidad de su historial | id | UUID | Contiene el identificador único del cliente registrado jurídico que se desea eliminar |  |  | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-CRJ-008 | Asegurar que cliente no este realizando algún proceso o transacción de compra en el momento de la eliminación | Generar una exepción indicando que el cliente se encuentra realizando una transacción importante en el momento, por lo que es imposible eliminarlo instantáneamente | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Vendedor | Registrar un nuevo cliente registrado jurídico | Permite registrar un nuevo cliente registrado jurídico en el sistema | ClienteRegistradoJuridico | Datos del nuevo cliente registrado jurídico | Contiene la información requerida para registrar un nuevo cliente registrado jurídico en el sistema | P-CRJ-001 | Asegurar que el id del cliente registrado jurídico sea único e irrepetible |  | Cliente registrado jurídico creado |  |
|  |  |  |  |  |  | P-CRJ-002 | Asegurar que el campo NIT del cliente registrado jurídico sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-CRJ-003 | Asegurar que el campo Telefono del cliente registrado jurídico sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-CRJ-004 | Asegurar que el campo Correo del cliente registrado jurídico sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-CRJ-005 | Asegurar que el campo RazonSocial del cliente registrado jurídico sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-CRJ-006 | Garantizar que el sistema debe validar que un mismo cliente registrado no esté asociado a más de un ClienteRegistradoNatural ni a un ClienteRegistradoJuridico |  |  |  |
|  |  |  |  |  |  | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar clientes registrados jurídicos por filtro | Permite buscar, listar y filtrar los clientes registrados jurídicos según los criterios de búsqueda enviados | ClienteRegistradoJuridico | Filtros de cliente registrado jurídico | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Clientes registrados jurídicos encontrados |  |
| Vendedor | Modificar un cliente registrado jurídico | Permite actualizar la información de un cliente registrado jurídico existente | ClienteRegistradoJuridico | Datos del cliente registrado jurídico a modificar | Tiene el identificador único del cliente registrado jurídico a modificar y la nueva información | P-CRJ-003 | Asegurar que el campo Telefono del cliente registrado jurídico sea único e irrepetible |  | Cliente registrado jurídico modificado |  |
|  |  |  |  |  |  | P-CRJ-004 | Asegurar que el campo Correo del cliente registrado jurídico sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-CRJ-005 | Asegurar que el campo RazonSocial del cliente registrado jurídico sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Vendedor | Eliminar un cliente registrado jurídico | Permite eliminar un cliente registrado jurídico conservando la trazabilidad de su historial | ClienteRegistradoJuridico | Identificador del cliente registrado jurídico a eliminar | Contiene el identificador único del cliente registrado jurídico que se desea eliminar | P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Cliente registrado jurídico eliminado |  |
|  |  |  |  |  |  | P-CRJ-008 | Asegurar que cliente no este realizando algún proceso o transacción de compra en el momento de la eliminación |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CRJ-001 | Asegurar que el id del cliente registrado jurídico sea único e irrepetible | ClienteRegistradoJuridico |
| P-CRJ-002 | Asegurar que el campo NIT del cliente registrado jurídico sea único e irrepetible | ClienteRegistradoJuridico |
| P-CRJ-003 | Asegurar que el campo Telefono del cliente registrado jurídico sea único e irrepetible | ClienteRegistradoJuridico |
| P-CRJ-004 | Asegurar que el campo Correo del cliente registrado jurídico sea único e irrepetible | ClienteRegistradoJuridico |
| P-CRJ-005 | Asegurar que el campo RazonSocial del cliente registrado jurídico sea único e irrepetible | ClienteRegistradoJuridico |
| P-CRJ-006 | Garantizar que el sistema debe validar que un mismo cliente registrado no esté asociado a más de un ClienteRegistradoNatural ni a un ClienteRegistradoJuridico | ClienteRegistradoJuridico |
| P-CRJ-007 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | ClienteRegistradoJuridico |
| P-CRJ-008 | Asegurar que cliente no este realizando algún proceso o transacción de compra en el momento de la eliminación | ClienteRegistradoJuridico |

[↑ Volver al índice](#objetos-de-dominio)

---

## Ciudad

**Descripción:** Representa la ciudad o municipio donde se ubican las sedes del negocio y residen los clientes.  
**Línea de vida:** 3

### Muestreo de datos

- **ID**: Identificador único de la ciudad
- **Departamento**: Departamento al que pertenece la ciudad
- **Nombre**: Nombre oficial de la ciudad o municipio
- **DepartamentoCiudad**: Combinación única que indica que no puede existir más de una ciudad con el mismo nombre en un mismo departamento

| ID | Departamento | Nombre | DepartamentoCiudad |
|---|---|---|---|
| 1 | Antioquia | Rionegro | Antioquia + Rionegro |
| 2 | Cundinamarca | La Ceja | Cundinamarca + La Ceja |
| 3 | Pichincha | Medellín | Pichincha + Medellín |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | consultarCiudadesPorFiltro | consultarCiudadesPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la ciudad | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las ciudades | No | No | - | No | No | - | - | Si | Filtro | No Mostrar |
| Departamento | Departamento al que pertenece la ciudad | No | Departamento | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Filtro | Mostrar |
| Nombre | Nombre oficial de la ciudad o municipio | No | Alfanumérico | Si | 2 | 100 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| DepartamentoCiudad | Combinación única que indica que no puede existir más de una ciudad con el mismo nombre en un mismo departamento | Departamento |
|  |  | Nombre |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| consultarCiudadesPorFiltro | Permite buscar, listar y filtrar las ciudades según los criterios de búsqueda enviados | filtro | Ciudad | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Ciudad> | Contiene la lista de ciudades que cumplen con las condiciones del filtro enviado | P-CIU-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Consultar ciudades por filtro | Permite buscar, listar y filtrar las ciudades según los criterios de búsqueda enviados | Ciudad | Filtros de ciudades | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-CIU-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  | Ciudades encontradas |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-CIU-001 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Ciudad |

[↑ Volver al índice](#objetos-de-dominio)

---

## Sede

**Descripción:** Representa cada local físico del negocio, donde se atienden las compras y se almacena la mercancía.  
**Línea de vida:** 4

### Muestreo de datos

- **ID**: Identificador único de la sede
- **Ciudad**: Ciudad en la que está ubicada la sede
- **Nombre**: Nombre con el que se identifica el local físico
- **Nit**: Número de NIT legal con el que se identifica la sede
- **Dirección**: Dirección física donde está ubicada la sede
- **EsActiva**: Variable booleana que define si una sede esta funcionando actualmente o no
- **NombreSedeUnico**: Combinación única que indica que no puede existir más de una sede con el mismo nombre
- **NitSedeUnico**: Combinación única que indica que no puede existir más de una sede con el mismo NIT
- **DireccionSedeUnica**: Combinación única que indica que no puede existir más de una sede con la misma Dirección

| ID | Ciudad | Nombre | Nit | Dirección | EsActiva | NombreSedeUnico | NitSedeUnico | DireccionSedeUnica |
|---|---|---|---|---|---|---|---|---|
| 1 | Rionegro | Saraitel San Nicolás | 890.900.608-9 | CC San Nicolás, Local 120 | SI | Saraitel San Nicolás | 890.900.608-9 | CC San Nicolás, Local 120 |
| 2 | Rionegro | Saraitel San Antonio | 860.005.224-6 | Mall la Placita, Local 112- San Antonio de Pereira | SI | Saraitel San Antonio | 860.005.224-6 | Mall la Placita, Local 112- San Antonio de Pereira |
| 3 | Medellín | Saraitel La Ceja | 890.301.884-0 | Cl 51 #38-20, La Ceja del Tambo | NO | Saraitel La Ceja | 890.301.884-0 | Cl 51 #38-20, La Ceja del Tambo |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarSede | consultarSedesPorFiltro | consultarSedesPorFiltro | modificarSede | modificarSede |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la sede | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las sedes | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No Modificable |
| Ciudad | Ciudad en la que está ubicada la sede | No | Ciudad | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | No Modificable |
| Nombre | Nombre con el que se identifica el local físico | No | Alfanumérico | Si | 2 | 100 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable |
| Nit | Número de NIT legal con el que se identifica la sede | No | Alfanumérico | Si | 6 | 20 | - | - | - | - | Formato valido de NIT 897468876-9 | Debe ser un NIT válido con dígito de verificación correcto, y debe ser único por sede | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable |
| Dirección | Dirección física donde está ubicada la sede | No | Alfanumérico | Si | 5 | 200 | - | - | - | - | - | Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque | No | No | - | Si | Si | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable |
| EsActiva | Variable booleana que define si una sede esta funcionando actualmente o no | Si | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO y es ingresado por el administrador; al pasar a NO la sede se inhabilita pero se conserva su historial | No | No | - | No | No | - | Si | No | Requerido | Filtro | Mostrar | Requerido | Modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| NombreSedeUnico | Combinación única que indica que no puede existir más de una sede con el mismo nombre | Nombre |
| NitSedeUnico | Combinación única que indica que no puede existir más de una sede con el mismo NIT | NIT |
| DireccionSedeUnica | Combinación única que indica que no puede existir más de una sede con la misma Dirección | Dirección |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarSede | Permite registrar una nueva sede en el sistema | datos | Sede | Contiene la información requerida para registrar la sede | Sede | Objeto de la sede registrada con su identificador ID asignado | P-SED-001 | Asegurar que el id de  la sede debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-SED-002 | Asegurar que el campo Nombre de sede debe ser único e irrepetible | Generar una excepción indicando que ya existe una sede con ese mismo Nombre | Detener operación |
|  |  |  |  |  |  |  | P-SED-003 | Asegurar que el campo NIT de sede debe ser único e irrepetible | Generar una excepción indicando que ya existe una sede con ese mismo NIT | Detener operación |
|  |  |  |  |  |  |  | P-SED-004 | Asegurar que el campo Dirección de sede debe ser único e irrepetible | Generar una excepción indicando que ya existe una sede con ese mismo Dirección | Detener operación |
|  |  |  |  |  |  |  | P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarSedesPorFiltro | Permite buscar, listar y filtrar las sedes según los criterios de búsqueda enviados | filtro | Sede | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Sede> | Contiene la lista de sedes que cumplen con las condiciones del filtro enviado | P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarSede | Permite actualizar la información de una sede existente | id | UUID | Tiene el identificador único de la sede a modificar y la nueva información | Sede | Objeto de la sede con su información actualizada | P-SED-002 | Asegurar que el campo Nombre de sede debe ser único e irrepetible | Generar una excepción indicando que ya existe una sede con ese mismo Nombre | Detener operación |
|  |  |  |  |  |  |  | P-SED-003 | Asegurar que el campo NIT de sede debe ser único e irrepetible | Generar una excepción indicando que ya existe una sede con ese mismo NIT | Detener operación |
|  |  | datos | Sede |  |  |  | P-SED-004 | Asegurar que el campo Dirección de sede debe ser único e irrepetible | Generar una excepción indicando que ya existe una sede con ese mismo Dirección | Detener operación |
|  |  |  |  |  |  |  | P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar una nueva sede | Permite registrar una nueva sede en el sistema | Sede | Datos de la nueva sede | Contiene la información requerida para registrar la sede | P-SED-001 | Asegurar que el id de  la sede debe ser único e irrepetible |  | Sede registrada |  |
|  |  |  |  |  |  | P-SED-002 | Asegurar que el campo Nombre de sede debe ser único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-SED-003 | Asegurar que el campo NIT de sede debe ser único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-SED-004 | Asegurar que el campo Dirección de sede debe ser único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar sedes por filtro | Permite buscar, listar y filtrar las sedes según los criterios de búsqueda enviados | Sede | Filtros de sedes | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Sedes encontradas |  |
| Administrador | Modificar una sede | Permite actualizar la información de una sede existente | Sede | Datos de la sede a modificar | Tiene el identificador único de la sede a modificar y la nueva información | P-SED-002 | Asegurar que el campo Nombre de sede debe ser único e irrepetible |  | Sede modificada |  |
|  |  |  |  |  |  | P-SED-003 | Asegurar que el campo NIT de sede debe ser único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-SED-004 | Asegurar que el campo Dirección de sede debe ser único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-SED-001 | Asegurar que el id de  la sede debe ser único e irrepetible | Sede |
| P-SED-002 | Asegurar que el campo Nombre de sede debe ser único e irrepetible | Sede |
| P-SED-003 | Asegurar que el campo NIT de sede debe ser único e irrepetible | Sede |
| P-SED-004 | Asegurar que el campo Dirección de sede debe ser único e irrepetible | Sede |
| P-SED-005 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Sede |

[↑ Volver al índice](#objetos-de-dominio)

---

## IngresoInventario

**Descripción:** Representa la factura de la llegada de nueva mercancía a una sede por parte de un proveedor que la creó previamente.  
**Línea de vida:** 5

### Muestreo de datos

- **ID**: Identificador único del ingreso de inventario
- **Sede**: Nombre de la sede que recibe la mercancía
- **FechaLlegada**: Fecha en que llega la mercancía a la sede
- **Total**: Valor total de la mercancía ingresada
- **Estado**: Estado actual de la ingreso de inventario (En proceso, Cancelado y Creado)
- **LlegadaInventarioSedeUnico**: Combinación única que indica que no puede existir más de un ingresoInventario en la misma sede a la misma hora de ingreso

| ID | Sede | FechaLlegada | Total | Estado | LlegadaInventarioSedeUnico |
|---|---|---|---|---|---|
| 1 | Saraitel San Nicolás | 04/03/2026 - 7:00 pm | 1000000 | Creado | Saraitel San Nicolás + 04/03/2026 - 7:00 pm |
| 2 | Saraitel San Antonio | 05/02/2026 - 5:00 am | 5000000 | Creado | Saraitel San Antonio + 05/02/2026 - 5:00 am |
| 3 | Saraitel La Ceja | 06/02/2026 - 10:00 am | 2500000 | Cancelado | Saraitel La Ceja + 06/02/2026 - 10:00 am |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarIngresoInventario | consultarIngresosInventarioPorFiltro | consultarIngresosInventarioPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del ingreso de inventario | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los ingresos de inventario | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Sede | Nombre de la sede que recibe la mercancía | No | Sede | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| FechaLlegada | Fecha en que llega la mercancía a la sede | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA   HH:MM | No puede ser una fecha posterior a la fecha y hora actual del sistema | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |
| Total | Valor total de la mercancía ingresada | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Es un valor  que se calcula a partir de  el costoUnitario*cantidad de cada producto de detalleIngreso | Si | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| Estado | Estado actual de la ingreso de inventario (En proceso, Cancelado y Creado) | No | Texto | Si | 6 | 20 | - | - | - | - | - | Solo puede tomar los estados definidos para el ingreso de inventario y sus cambios deben realizarse de acuerdo con las transiciones permitidas por el proceso de compra. | No | No | - | Si | Si | - | Pendiente | Si | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| LlegadaInventarioSedeUnico | Combinación única que indica que no puede existir más de un ingresoInventario en la misma sede a la misma hora de ingreso | Sede |
|  |  | FechaLlegada |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarIngresoInventario | Permite registrar un nuevo ingreso de inventario en el sistema | datos | IngresoInventario | Contiene la información requerida para registrar el ingreso de inventario | IngresoInventario | Objeto del ingreso de inventario registrado con su identificador ID asignado | P-ING-001 | Asegurar que el id de ingreso de inventario sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-ING-002 | Asegurar que solo se registren ingresos en una sede activa | Generar una excepción indicando que la sede no esta activa en el momento | Detener operación |
|  |  |  |  |  |  |  | P-ING-003 | Asegurar que el ingreso de inventario a una sede específica no ocurra al mismo tiempo que otro ingreso | Generar una excepción indicando que en la sede no se puede tener un ingreso de inventario ingresando a una misma sede a la misma hora | Detener operación |
|  |  |  |  |  |  |  | P-ING-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarIngresosInventarioPorFiltro | Permite buscar, listar y filtrar los ingresos de inventario según los criterios de búsqueda enviados | filtro | IngresoInventario | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<IngresoInventario> | Contiene la lista de ingresos de inventario que cumplen con las condiciones del filtro enviado | P-ING-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo ingreso de inventario | Permite registrar un nuevo ingreso de inventario en el sistema | IngresoInventario | Datos del nuevo ingreso de inventario | Contiene la información requerida para registrar el ingreso de inventario | P-ING-001 | Asegurar que el id de ingreso de inventario sea único e irrepetible |  | Ingreso de inventario registrado |  |
|  |  |  |  |  |  | P-ING-002 | Asegurar que solo se registren ingresos en una sede activa |  |  |  |
|  |  |  |  |  |  | P-ING-003 | Asegurar que el ingreso de inventario a una sede específica no ocurra al mismo tiempo que otro ingreso |  |  |  |
|  |  |  |  |  |  | P-ING-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador | Consultar ingresos de inventario por filtro | Permite buscar, listar y filtrar los ingresos de inventario según los criterios de búsqueda enviados | IngresoInventario | Filtros de ingresos de inventario | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-ING-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Ingresos de inventario encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-ING-001 | Asegurar que el id de ingreso de inventario sea único e irrepetible | IngresoInventario |
| P-ING-002 | Asegurar que solo se registren ingresos en una sede activa | IngresoInventario |
| P-ING-003 | Asegurar que el ingreso de inventario a una sede específica no ocurra al mismo tiempo que otro ingreso | IngresoInventario |
| P-ING-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | IngresoInventario |
| P-ING-005 | Asegurar que todo IngresoInventario nuevo inicie con estado En proceso. | IngresoInventario |

[↑ Volver al índice](#objetos-de-dominio)

---

## Empleado

**Descripción:** Representa al personal contratado que trabaja en una sede específica, es quien atiende las compras de los clientes.  
**Línea de vida:** 5

### Muestreo de datos

- **ID**: Identificador único del empleado
- **Sede**: Nombre de la sede donde trabaja el empleado
- **Persona**: Representa a un individuo en el sistema con sus datos de identificación  para registrarse en el sistema y emplearse en el negocio
- **EsActivo**: Variable booleana que define si un Empleado esta trabajando actualmente en la empresa o no
- **PersonaEmpleadaUnica**: Combinación única que indica que no puede existir más de un empleado con la misma persona asociada

| ID | Sede | Persona | EsActivo | PersonaEmpleadaUnica |
|---|---|---|---|---|
| 1 | Saraitel San Nicolás | Carlos Andrés Riaño | SI | Carlos Andrés Riaño |
| 2 | Saraitel La Ceja | Mariana Jiménez | SI | Mariana Jiménez |
| 3 | Saraitel San Nicolás | Valentina Vélez | NO | Valentina Vélez |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarEmpleado | consultarEmpleadosPorFiltro | consultarEmpleadosPorFiltro | modificarEmpleado | modificarEmpleado |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del empleado | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los empleados | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable |
| Sede | Nombre de la sede donde trabaja el empleado | No | Sede | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | Requerido | Modificable |
| Persona | Representa a un individuo en el sistema con sus datos de identificación  para registrarse en el sistema y emplearse en el negocio | No | Persona | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable |
| EsActivo | Variable booleana que define si un Empleado esta trabajando actualmente en la empresa o no | No | Lógico | Si | - | - | - | - | - | - | - | Solo admite SI o NO y es ingresado por el administrador; al pasar a NO el empleado se inhabilita pero se conserva su historial | No | No | - | No | No | - | Si | No | Requerido | Filtro | Mostrar | Requerido | Modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| PersonaEmpleadaUnica | Combinación única que indica que no puede existir más de un empleado con la misma persona asociada | Persona |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarEmpleado | Permite registrar un nuevo empleado en el sistema | datos | Empleado | Contiene la información requerida para registrar el empleado | Empleado | Objeto del empleado registrado con su identificador ID asignado, sede, persona y estado de actividad | P-EMP-001 | El id de empleado debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-EMP-002 | El sistema debe garantizar que una misma persona no esté asociada a más de un empleado para evitar duplicación de personas | Generar una excepción indicando que ya existe un empleado con esa misma persona asociada | Detener operación |
|  |  |  |  |  |  |  | P-EMP-003 | Asegurar que la sede en la que se asigna el empleado esté activa actualmente | Generar una excepción indicando que la sede no esta activa en el momento | Detener operación |
|  |  |  |  |  |  |  | P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarEmpleadosPorFiltro | Permite buscar, listar y filtrar los empleados según los criterios de búsqueda enviados | filtro | Empleado | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Empleado> | Contiene la lista de empleados que cumplen con las condiciones del filtro enviado | P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarEmpleado | Permite actualizar la información de un empleado existente | id | UUID | Tiene el identificador único del empleado a modificar y la nueva información | Empleado | Objeto del empleado con su información actualizada | P-EMP-003 | Asegurar que la sede en la que se asigna el empleado esté activa actualmente | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  | datos | Empleado |  |  |  | P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que el empleado no existe o no puede ser modificado | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo empleado | Permite registrar un nuevo empleado en el sistema | Empleado | Datos del nuevo empleado | Contiene la información requerida para registrar el empleado | P-EMP-001 | El id de empleado debe ser único e irrepetible |  | Empleado registrado |  |
|  |  |  |  |  |  | P-EMP-002 | El sistema debe garantizar que una misma persona no esté asociada a más de un empleado para evitar duplicación de personas |  |  |  |
|  |  |  |  |  |  | P-EMP-003 | Asegurar que la sede en la que se asigna el empleado esté activa actualmente |  |  |  |
|  |  |  |  |  |  | P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador | Consultar empleados por filtro | Permite buscar, listar y filtrar los empleados según los criterios de búsqueda enviados | Empleado | Filtros y catálogo de empleados | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Empleados encontrados |  |
| Administrador | Modificar un empleado | Permite actualizar la información de un empleado existente | Empleado | Datos del empleado a modificar | Tiene el identificador único del empleado a modificar y la nueva información | P-EMP-003 | Asegurar que la sede en la que se asigna el empleado esté activa actualmente |  | Empleado modificado |  |
|  |  |  |  |  |  | P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-EMP-001 | El id de empleado debe ser único e irrepetible | Empleado |
| P-EMP-002 | El sistema debe garantizar que una misma persona no esté asociada a más de un empleado para evitar duplicación de personas | Empleado |
| P-EMP-003 | Asegurar que la sede en la que se asigna el empleado esté activa actualmente | Empleado |
| P-EMP-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Empleado |

[↑ Volver al índice](#objetos-de-dominio)

---

## ProductoSede

**Descripción:** Representa el inventario real de un producto en una sede determinada.  
**Línea de vida:** 5

### Muestreo de datos

- **ID**: Identificador único del inventario físico producto-sede
- **Producto**: Producto del catálogo general de la empresa
- **Sede**: Nombre de la sede donde se encuentra el inventario
- **Precio**: Precio de venta local del producto en la sede
- **TieneOferta**: Variable booleana que define si un producto específico en una sede tiene oferta actualmente o no
- **Oferta**: Oferta que se le aplica al producto correspondiente, definida por el administrador
- **PrecioTrasOferta**: Valor calculado al aplicar el descuento correspondiente al precio del producto en cuestión
- **Stock**: Cantidad de unidades disponibles del producto en la sede, valor calculado como consecuencia de operaciones de inventario permitidas
- **StockGarantía**: Cantidad de unidades que necesitan cambio del producto específico en la sede, valor calculado como consecuencia de operaciones de inventario permitidas
- **ProductoSedeUnico**: Combinación única que indica que un mismo producto no puede repetirse en una misma sede

| ID | Producto | Sede | Precio | TieneOferta | Oferta | PrecioTrasOferta | Stock | StockGarantía | ProductoSedeUnico |
|---|---|---|---|---|---|---|---|---|---|
| 1 | LWFIP14 | Saraitel San Nicolás | 45000 | SI | 0.2 | 36000 | 0 | 1 | LWFIP14  + Saraitel San Nicolás |
| 2 | VDIP13 | Saraitel San Nicolás | 35000 | NO | 0 | 35000 | 25 | 0 | VDIP13 + Saraitel San Nicolás |
| 3 | TPCIP35w | Saraitel San Antonio | 70000 | NO | 0 | 70000 | 12 | 5 | TPCIP35w + Saraitel San Antonio |
| 4 | AirDots 2 | Saraitel La Ceja | 90000 | NO | 0 | 90000 | 15 | 3 | AirDots 2 + Saraitel La Ceja |
| 5 | VDA12 | Saraitel San Antonio | 30000 | SI | 0.3 | 21000 | 8 | 2 | VDA12 + Saraitel San Antonio |
| 6 | CU16 | Saraitel La Ceja | 30000 | SI | 0.15 | 25500 | 30 | 8 | CU16 + Saraitel La Ceja |
| 7 | IG-029 | Saraitel San Nicolás | 130000 | NO | 0 | 130000 | 25 | 12 | IG-029 + Saraitel San Nicolás |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarProductoSede | consultarProductosSedePorFiltro | consultarProductosSedePorFiltro | modificarProductoSede | modificarProductoSede | retirarStockGarantia |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del inventario físico producto-sede | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los inventarios producto-sede | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable | Requerido |
| Producto | Producto del catálogo general de la empresa | No | Producto | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable | No requerido |
| Sede | Nombre de la sede donde se encuentra el inventario | No | Sede | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable | No requerido |
| Precio | Precio de venta local del producto en la sede | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Debe ser un valor positivo o cero; se define de forma local por sede | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | Modificable | No requerido |
| TieneOferta | Variable booleana que define si un producto específico en una sede tiene oferta actualmente o no | No | Lógico | Si | - | - | - | - | 0 | - | - | Solo admite SI o NO; si es NO la oferta debe quedar en cero | No | No | - | No | No | - | No | No | No requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Oferta | Oferta que se le aplica al producto correspondiente, definida por el administrador | No | Numérico Entero | No | - | - |  |  | 0 | 100 | Formato porcentaje, número entero entre 0 y 100 seguido por el signo '%' | Debe ser un número entero, de 0 a 100, en caso de no haber oferta, el valor es 0 | No | No | - | No | No | - | 0 | No | No requerido | No Filtro | Mostrar | No requerido | Modificable | No requerido |
| PrecioTrasOferta | Valor calculado al aplicar el descuento correspondiente al precio del producto en cuestión | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | PrecioUnitario* (1 - (Oferta / 100)); no puede ser negativo. | Si | No | - | No | No | - | - | No | No requerido | Filtro | Mostrar | No requerido | No modificable | No requerido |
| Stock | Cantidad de unidades disponibles del producto en la sede, valor calculado como consecuencia de operaciones de inventario permitidas | No | Numérico Entero | Si | - | - | - | - | 0 | - | - | No puede ser negativo; se actualiza cada vez que ocurre una compra, un ingreso o devolución | Si | No | - | No | No | - | - | No | No requerido | Filtro | Mostrar | No requerido | No modificable | No requerido |
| StockGarantía | Cantidad de unidades que necesitan cambio del producto específico en la sede, valor calculado como consecuencia de operaciones de inventario permitidas | No | Numérico Entero | Si | - | - | - | - | 0 | - | - | No puede ser negativo, se calcula a partir de cada devolucion que aplice el motivo garantía | Si | No | - | No | No | - | - | No | No requerido | Filtro | Mostrar | No requerido | Modificable | Requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| ProductoSedeUnico | Combinación única que indica que un mismo producto no puede repetirse en una misma sede | Producto |
|  |  | Sede |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarProductoSede | Permite registrar un nuevo producto de sede en el sistema | datos | ProductoSede | Contiene la información requerida para registrar el producto de sede | ProductoSede | Objeto del producto de sede registrado con su identificador ID asignado, producto y sede asociados, y demas atributos de valor del objeto | P-PSE-001 | Asegurar de que el id de producto de sede sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-PSE-002 | Asegurar que el producto en esa sede específica sea único e irrepetible | Generar una excepción indicando que ya existe un producto de sede con la misma combinación de Producto y Sede. | Detener operación |
|  |  |  |  |  |  |  | P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarProductosSedePorFiltro | Permite buscar, listar y filtrar los productos de sede según los criterios de búsqueda enviados | filtro | ProductoSede | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<ProductoSede> | Contiene la lista de productos de sede que cumplen con las condiciones del filtro enviado | P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarProductoSede | Permite actualizar la información de un producto de sede existente | Id | UUID | Tiene el identificador único del producto de sede a modificar y la nueva información | ProductoSede | Objeto del producto de sede con su información actualizada | P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  | datos | ProductoSede |  |  |  |  |  |  |  |
| retirarStockGarantia | Permite retirar una cantidad determinada de unidades del StockGarantia específicas de un ProductoSede ingresadas por el administrador | datos | ProductoSede  +  Cantidad | Contiene el identificador de producto sede y la cantidad de unidades de garantia que se desean retirar | ProductoSede | Objeto del producto de sede registrado con su identificador ID asignado, producto y sede asociados, y demas atributos de valor del objeto | P-PSE-004 | Asegurar que la cantidad a retirar sea válida y mayor que cero | Generar una excepción indicando que la cantidad ingresada a retirar es inválida o no ha sido ingresada | Continuar operación |
|  |  |  |  |  |  |  | P-PSE-005 | Asegurar que la cantidad a retirar no sea superior al StockGarantia disponible | Generar una excepción indicando que ya existe un producto de sede con la misma combinación de Producto y Sede. | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo producto de sede | Permite registrar un nuevo producto de sede en el sistema | ProductoSede | Datos del nuevo producto de sede | Contiene la información requerida para registrar el producto de sede | P-PSE-001 | Asegurar de que el id de producto de sede sea único e irrepetible |  | Producto de sede registrado |  |
|  |  |  |  |  |  | P-PSE-002 | Asegurar que el producto en esa sede específica sea único e irrepetible |  |  |  |
|  |  |  |  |  |  | P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar productos de sede por filtro | Permite buscar, listar y filtrar los productos de sede según los criterios de búsqueda enviados | ProductoSede | Filtros de productos de sede | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Productos de sede encontrados |  |
| Administrador | Modificar un producto de sede | Permite actualizar la información de un producto de sede existente | ProductoSede | Datos del producto de sede a modificar | Tiene el identificador único del producto de sede a modificar y la nueva información | P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Producto de sede modificado |  |
| Administrador | Retirar stock garantia | Permite retirar una cantidad determinada de unidades del StockGarantia específicas de un ProductoSede ingresadas por el administrador | ProductoSede | Datos del producto sede y cantidad de retiro | Identificador del ProductoSede y cantidad de unidades de stock garantía que se desean retirar | P-PSE-004 | Asegurar que la cantidad a retirar sea válida y mayor que cero |  | StockGarantía retirado |  |
|  |  |  |  |  |  | P-PSE-005 | Asegurar que la cantidad a retirar no sea superior al StockGarantia disponible |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PSE-001 | Asegurar de que el id de producto de sede sea único e irrepetible | ProductoSede |
| P-PSE-002 | Asegurar que el producto en esa sede específica sea único e irrepetible | ProductoSede |
| P-PSE-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | ProductoSede |
| P-PSE-004 | Asegurar que la cantidad a retirar sea válida y mayor que cero | ProductoSede |
| P-PSE-005 | Asegurar que la cantidad a retirar no sea superior al StockGarantia disponible | ProductoSede |

[↑ Volver al índice](#objetos-de-dominio)

---

## Administrador

**Descripción:** Representa la especialización del empleado con permisos administrativos sobre la operación del negocio.  
**Línea de vida:** 6

### Muestreo de datos

- **ID**: Identificador único del administrador
- **Empleado**: Referencia al empleado que desempeña el rol de administrador
- **EmpleadoAdministradorUnico**: Combinación única que representa que no puede existir el mismo empleado mas de una vez siendo administrador

| ID | Empleado | EmpleadoAdministradorUnico |
|---|---|---|
| 1 | 1 | 1 |
| 2 | 2 | 2 |
| 3 | 3 | 3 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarAdministrador | consultarAdministradoresPorFiltro | consultarAdministradoresPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del administrador | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los administradores | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Empleado | Referencia al empleado que desempeña el rol de administrador | No | Empleado | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| EmpleadoAdministradorUnico | Combinación única que representa que no puede existir el mismo empleado mas de una vez siendo administrador | Empleado |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarAdministrador | Permite registrar un nuevo administrador en el sistema | datos | Administrador | Contiene la información requerida para registrar el administrador | Administrador | Objeto del administrador registrado con su identificador ID asignado y empleado correspondiente | P-ADM-001 | Asegurar que el id de administrador debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-ADM-002 | El sistema debe garantizar que un mismo empleado no esté asociado a más de un administrador ni un vendedor para evitar duplicación de empleados | Generar una excepción indicando que ya existe un administrador o vendedor con ese mismo empleado asociado | Detener operación |
|  |  |  |  |  |  |  | P-ADM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarAdministradoresPorFiltro | Permite buscar, listar y filtrar los administradores según los criterios de búsqueda enviados | filtro | Administrador | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Administrador> | Contiene la lista de administradores que cumplen con las condiciones del filtro enviado | P-ADM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador del sistema | Registrar un nuevo administrador | Permite registrar un nuevo administrador en el sistema | Administrador | Datos del nuevo administrador | Contiene la información requerida para registrar el administrador | P-ADM-001 | Asegurar que el id de administrador debe ser único e irrepetible |  | Administrador registrado |  |
|  |  |  |  |  |  | P-ADM-002 | El sistema debe garantizar que un mismo empleado no esté asociado a más de un administrador ni un vendedor para evitar duplicación de empleados |  |  |  |
|  |  |  |  |  |  | P-ADM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador | Consultar administradores por filtro | Permite buscar, listar y filtrar los administradores según los criterios de búsqueda enviados | Administrador | Filtros de administradores | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-ADM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Administradores encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-ADM-001 | Asegurar que el id de administrador debe ser único e irrepetible | Administrador |
| P-ADM-002 | El sistema debe garantizar que un mismo empleado no esté asociado a más de un administrador ni un vendedor para evitar duplicación de empleados | Administrador |
| P-ADM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Administrador |

[↑ Volver al índice](#objetos-de-dominio)

---

## Vendedor

**Descripción:** Representa la especialización del empleado encargado de atender a los clientes en la sede.  
**Línea de vida:** 6

### Muestreo de datos

- **ID**: Identificador único del vendedor
- **Empleado**: Referencia al empleado que desempeña el rol de vendedor
- **EmpleadoVendedorUnico**: Combinación única que representa que no puede existir el mismo empleado mas de una vez siendo vendedor

| ID | Empleado | EmpleadoVendedorUnico |
|---|---|---|
| 1 | 1 | 1 |
| 2 | 2 | 2 |
| 3 | 3 | 3 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarVendedor | consultarVendedoresPorFiltro | consultarVendedoresPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del vendedor | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los vendedores | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Empleado | Referencia al empleado que desempeña el rol de vendedor | No | Empleado | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| EmpleadoVendedorUnico | Combinación única que representa que no puede existir el mismo empleado mas de una vez siendo vendedor | Empleado |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarVendedor | Permite registrar un nuevo vendedor en el sistema | datos | Vendedor | Contiene la información requerida para registrar el vendedor | Vendedor | Objeto del vendedor registrado con su identificador ID asignado y empleado correspondiente | P-VEN-001 | Asegurar que el id de vendedor sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-VEN-002 | El sistema debe garantizar que un mismo empleado no esté asociado a más de un vendedor ni un administrador para evitar duplicación de empleados | Generar una excepción indicando que ya existe un administrador o vendedor con ese mismo empleado asociado | Detener operación |
|  |  |  |  |  |  |  | P-VEN-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarVendedoresPorFiltro | Permite buscar, listar y filtrar los vendedores según los criterios de búsqueda enviados | filtro | Vendedor | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Vendedor> | Contiene la lista de vendedores que cumplen con las condiciones del filtro enviado | P-VEN-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo vendedor | Permite registrar un nuevo vendedor en el sistema | Vendedor | Datos del nuevo vendedor | Contiene la información requerida para registrar el vendedor | P-VEN-001 | Asegurar que el id de vendedor sea único e irrepetible |  | Vendedor registrado |  |
|  |  |  |  |  |  | P-VEN-002 | El sistema debe garantizar que un mismo empleado no esté asociado a más de un vendedor ni un administrador para evitar duplicación de empleados |  |  |  |
|  |  |  |  |  |  | P-VEN-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador | Consultar vendedores por filtro | Permite buscar, listar y filtrar los vendedores según los criterios de búsqueda enviados | Vendedor | Filtros de vendedores | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-VEN-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Vendedores encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-VEN-001 | Asegurar que el id de vendedor sea único e irrepetible | Vendedor |
| P-VEN-002 | El sistema debe garantizar que un mismo empleado no esté asociado a más de un vendedor ni un administrador para evitar duplicación de empleados | Vendedor |
| P-VEN-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Vendedor |

[↑ Volver al índice](#objetos-de-dominio)

---

## ProcesoCompra

**Descripción:** Representa el flujo que controla los estados y transiciones de una compra.  
**Línea de vida:** 6

### Muestreo de datos

- **ID**: Identificador único del proceso de compra
- **Cliente**: Cliente asociado al proceso de compra
- **Empleado**: Empleado responsable del proceso de compra
- **FechaInicio**: Fecha de inicio del proceso de la compra
- **FechaActualizacion**: Fecha de última actualización del proceso de la compra
- **Total**: Valor total de la compra, se confirma el calculo cuando el estado es Creado
- **Estado**: Estado actual del proceso(En proceso, Anulado y Creado)
- **ClienteFechaInicio**: Combinación única que representa que un mismo cliente no puede generar un proceso compra en una misma hora
- **EmpleadoFechaInicio**: Combinación única que representa que un mismo empleado no pueda atender un proceso compra en una misma hora
- **ClienteFechaActualizacion**: Combinación única que representa que un mismo cliente no puede actualizar un proceso de compra en una misma hora
- **EmpleadoFechaActualizacion**: Combinación única que identifica el proceso de compra mediante el empleado asociado y evita registros duplicados para un mismo cliente

| ID | Cliente | Empleado | FechaInicio | FechaActualizacion | Total | Estado | ClienteFechaInicio | EmpleadoFechaInicio | ClienteFechaActualizacion | EmpleadoFechaActualizacion |
|---|---|---|---|---|---|---|---|---|---|---|
| 1 | 1 | 1 | 01/02/2026 - 9:02 am | 01/12/2026 - 5:15 pm | 205000 | En proceso | 1 + 01/02/2026 - 9:02 am | 1 + 01/02/2026 - 9:02 am | 1 + 01/12/2026 - 5:15 pm | 1 + 01/12/2026 - 5:15 pm |
| 2 | 2 | 2 | 02/02/2026 - 11:15 am | 11/09/2026 - 9:30 am | 70000 | Anulado | 2 + 02/02/2026 - 11:15 am | 2 + 02/02/2026 - 11:15 am | 2 + 11/09/2026 - 9:30 am | 2 + 11/09/2026 - 9:30 am |
| 3 | 3 | 3 | 15/02/2026 - 2:30 pm | 15/10/2026 - 10:55 pm | 90000 | En proceso | 3 + 15/02/2026 - 2:30 pm | 3 + 15/02/2026 - 2:30 pm | 3 + 15/10/2026 - 10:55 pm | 3 + 15/10/2026 - 10:55 pm |
| 4 | 4 | 0 | 04/03/2026 - 7:00 pm | 04/03/2026 - 8:10 pm | 30000 | Creado | 4 + 04/03/2026 - 7:00 pm | 0 + 04/03/2026 - 7:00 pm | 4 + 04/03/2026 - 8:10 pm | 0 + 04/03/2026 - 8:10 pm |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarProcesoCompra | consultarProcesosCompraPorFiltro | consultarProcesosCompraPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del proceso de compra | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no repetirse en los distintos id's de los procesos de compra | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Cliente | Cliente asociado al proceso de compra | No | Cliente | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| Empleado | Empleado responsable del proceso de compra | No | Empleado | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| FechaInicio | Fecha de inicio del proceso de la compra | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA HH:MM | Se asigna automáticamente al iniciar un ProcesoCompra, no puede ser posterior a la fecha y hora actual del sistema | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |
| FechaActualizacion | Fecha de última actualización del proceso de la compra | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA HH:MM | No puede ser anterior a FechaInicio ni posterior a la fecha actual, se actualiza cada vez que se modifica algun detalle de la compra | No | No | - | Si | Si | - | - | Si | No Requerido | Filtro | Mostrar |
| TotalCompra | Valor total de la compra, se confirma el calculo cuando el estado es Creado | No | Número Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduría | Dato calculado con la suma de los subtotales de detalle compra, no se obtiene su valor real hasta que el estado de ProcesoCompra diga "Creado"; no puede ser negativo. | Si | No | - | No | No | - | - | No | No Requerido | Filtro | Mostrar |
| Estado | Estado actual del proceso(En proceso, Anulado y Creado) | No | Texto | Si | 6 | 12 | - | - | - | - | - | Solo puede tomar los estados definidos para el ProcesoCompra y sus cambios deben realizarse de acuerdo con las transiciones permitidas por el proceso de compra | No | No | - | No | No | - | En Proceso | Si | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| ClienteFechaInicio | Combinación única que representa que un mismo cliente no puede generar un proceso compra en una misma hora | Cliente |
|  |  | FechaInicio |
| EmpleadoFechaInicio | Combinación única que representa que un mismo empleado no pueda atender un proceso compra en una misma hora | Empleado |
|  |  | FechaInicio |
| ClienteFechaActualizacion | Combinación única que representa que un mismo cliente no puede actualizar un proceso de compra en una misma hora | Cliente |
|  |  | FechaActualizacion |
| EmpleadoFechaActualizacion | Combinación única que identifica el proceso de compra mediante el empleado asociado y evita registros duplicados para un mismo cliente | Empleado |
|  |  | FechaActualizacion |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarProcesoCompra | Permite registrar un nuevo proceso de compra en el sistema | datos | ProcesoCompra | Contiene la información requerida para registrar el proceso de compra | ProcesoCompra | Objeto del proceso de compra registrado con su identificador ID asignado y proceso compra correspondiente | P-PCO-001 | Asegurar que el id de proceso de compra sea único e irrepetible. | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-PCO-002 | Asegurar que un mismo cliente no pueda generar más de un proceso de compra en la misma fecha y hora de inicio | Generar una excepción indicando que ya existe un proceso de compra para el mismo Cliente en la misma fecha y hora de inicio. | Detener operación |
|  |  |  |  |  |  |  | P-PCO-003 | Asegurar que un mismo empleado no pueda atender más de un proceso de compra en la misma fecha y hora de inicio | Generar una excepción indicando que ya existe un proceso de compra atendido por el mismo Empleado en la misma fecha y hora de inicio. | Detener operación |
|  |  |  |  |  |  |  | P-PCO-004 | Asegurar que un mismo cliente no pueda actualizar más de un proceso de compra en la misma fecha y hora de actualización | Generar una excepción indicando que ya existe un proceso de compra del mismo Cliente en la misma fecha y hora de actualización. | Detener operación |
|  |  |  |  |  |  |  | P-PCO-005 | Asegurar que un mismo empleado no pueda atender más de un proceso de compra en la misma fecha y hora de actualización | Generar una excepción indicando que ya existe un registro de actualización para el mismo Empleado en la misma fecha y hora. | Detener operación |
|  |  |  |  |  |  |  | P-PCO-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-PCO-007 | Asegurar que un proceso compra en estado en proceso sea anulado automáticamente en 5 minutos después de su última fecha de actualización | Cambiar automáticamente el Estado del ProcesoCompra de En proceso a Cancelado | Actualizar estado |
| consultarProcesosCompraPorFiltro | Permite buscar, listar y filtrar los procesos de compra según los criterios de búsqueda enviados | filtro | ProcesoCompra | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<ProcesoCompra> | Contiene la lista de procesos de compra que cumplen con las condiciones del filtro enviado | P-PCO-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo proceso de compra | Permite registrar un nuevo proceso de compra en el sistema | ProcesoCompra | Datos del nuevo proceso de compra | Contiene la información requerida para registrar el proceso de compra | P-PCO-001 | Asegurar que el id de proceso de compra sea único e irrepetible. |  | Proceso de compra registrado |  |
|  |  |  |  |  |  | P-PCO-002 | Asegurar que un mismo cliente no pueda generar más de un proceso de compra en la misma fecha y hora de inicio |  |  |  |
|  |  |  |  |  |  | P-PCO-003 | Asegurar que un mismo empleado no pueda atender más de un proceso de compra en la misma fecha y hora de inicio |  |  |  |
|  |  |  |  |  |  | P-PCO-004 | Asegurar que un mismo cliente no pueda actualizar más de un proceso de compra en la misma fecha y hora de actualización |  |  |  |
|  |  |  |  |  |  | P-PCO-005 | Asegurar que un mismo empleado no pueda atender más de un proceso de compra en la misma fecha y hora de actualización |  |  |  |
|  |  |  |  |  |  | P-PCO-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  |  |  |
|  |  |  |  |  |  | P-PCO-007 | Asegurar que un proceso compra en estado en proceso sea anulado automáticamente en 5 minutos después de su última fecha de actualización |  |  |  |
| Administrador/Vendedor | Consultar procesos de compra por filtro | Permite buscar, listar y filtrar los procesos de compra según los criterios de búsqueda enviados | ProcesoCompra | Filtros y catálogo de procesos de compra | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-PCO-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  | Procesos de compra encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PCO-001 | Asegurar que el id de proceso de compra sea único e irrepetible. | ProcesoCompra |
| P-PCO-002 | Asegurar que un mismo cliente no pueda generar más de un proceso de compra en la misma fecha y hora de inicio | ProcesoCompra |
| P-PCO-003 | Asegurar que un mismo empleado no pueda atender más de un proceso de compra en la misma fecha y hora de inicio | ProcesoCompra |
| P-PCO-004 | Asegurar que un mismo cliente no pueda actualizar más de un proceso de compra en la misma fecha y hora de actualización | ProcesoCompra |
| P-PCO-005 | Asegurar que un mismo empleado no pueda atender más de un proceso de compra en la misma fecha y hora de actualización | ProcesoCompra |
| P-PCO-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | ProcesoCompra |
| P-PCO-007 | Asegurar que un proceso compra en estado en proceso sea anulado automáticamente en 5 minutos después de su última fecha de actualización | ProcesoCompra |

[↑ Volver al índice](#objetos-de-dominio)

---

## DetalleIngreso

**Descripción:** Representa el detalle de cada producto que entró de mercancía al negocio, su cantidad, precio y demás atributos.  
**Línea de vida:** 6

### Muestreo de datos

- **ID**: Identificador único de cada detalle del ingreso
- **IngresoInventario**: Factura de ingreso de inventario al que pertenece cada detalle de producto correspondiente
- **ProductoSede**: Hace referencia al producto sede que ingresa en la factura correspondiente
- **Cantidad**: Cantidad de unidades que ingresan de ese producto
- **CostoUnitario**: Costo de compra por unidad del producto específico
- **Subtotal**: Resultado de cantidad por el costo unitario del producto
- **DetalleIngresoUnico**: Combinación única que indica que un mismo producto sede no puede repetirse en una misma factura de ingreso

| ID | IngresoInventario | ProductoSede | Cantidad | CostoUnitario | Subtotal | DetalleIngresoUnico |
|---|---|---|---|---|---|---|
| 1 | 1 | LWFIP14  + Saraitel San Nicolás | 20 | 28000 | 560000 | 1 \|\| LWFIP14  + Saraitel San Nicolás |
| 2 | 2 | TPCIP35w + Saraitel San Antonio | 15 | 38000 | 570000 | 2 \|\| TPCIP35w + Saraitel San Antonio |
| 3 | 3 | AirDots 2 + Saraitel La Ceja | 8 | 50000 | 400000 | 3 \|\| AirDots 2 + Saraitel La Ceja |
| 4 | 3 | VDA12 + Saraitel San Antonio | 30 | 10000 | 300000 | 3 \|\| VDA12 + Saraitel San Antonio |
| 5 | 1 | CU16 + Saraitel La Ceja | 12 | 17000 | 204000 | 1 \|\| CU16 + Saraitel La Ceja |
| 6 | 2 | IG-029 + Saraitel San Nicolás | 5 | 80000 | 400000 | 2 \|\| IG-029 + Saraitel San Nicolás |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarDetalleIngreso | consultarDetallesIngresoPorFiltro | consultarDetallesIngresoPorFiltro | modificarDetalleIngreso | modificarDetalleIngreso | eliminarDetalleIngreso |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de cada detalle del ingreso | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los detalles de ingreso | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable | Requerido |
| IngresoInventario | Factura de ingreso de inventario al que pertenece cada detalle de producto correspondiente | No | IngresoInventario | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | No modificable | No requerido |
| ProductoSede | Hace referencia al producto sede que ingresa en la factura correspondiente | No | ProductoSede | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | No modificable | No requerido |
| Cantidad | Cantidad de unidades que ingresan de ese producto | No | Numérico Entero | Si | - | - | - | - | 1 | - | - | Debe ser un entero mayor que cero y es ingresado por el administrador | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| CostoUnitario | Costo de compra por unidad del producto específico | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Debe ser un valor positivo o igual a cero | No | No | - | No | No | Si | - | No | Requerido | Filtro | Mostrar | No Requerido | Modificable | No requerido |
| Subtotal | Resultado de cantidad por el costo unitario del producto | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Es un dato calculado, es la cantidad * valor unitario de la línea de detalle, no se ingresa de forma manualmente; no puede ser negativo. | Si | No | - | No | No | Si | - | No | No Requerido | Filtro | Mostrar | No Requerido | No modificable | No requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| DetalleIngresoUnico | Combinación única que indica que un mismo producto sede no puede repetirse en una misma factura de ingreso | IngresoInventario |
|  |  | ProductoSede |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Descripción | Políticas (Reglas de Negocio) / Política | Excepción / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarDetalleIngreso | Permite registrar un nuevo detalle de ingreso en el sistema | datos | DetalleIngreso | Contiene la información requerida para registrar el detalle de ingreso | DetalleIngreso | Objeto del detalle de ingreso registrado con su identificador ID asignado y demas atributos del objeto | P-DIN-001 | Asegurar que el id de detalle de ingreso sea único e irrepetible. | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-DIN-002 | Asegurar que la combinación de la factura de ingreso y el producto-sede sea única e irrepetible | Generar una excepción indicando que ya existe un detalle de ingreso con la misma combinación de IngresoInventario y ProductoSede. | Detener operación |
|  |  |  |  |  |  |  | P-DIN-003 | Asegurar que la sede asociada a los producto sede ingresados correspondan a la sede que esta asociada con el ingreso inventario respectivo | Generar una excepción indicando que no fue posible determinar la sede a la que pertenecen los productos | Detener operación |
|  |  |  |  |  |  |  | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | Generar una excepción indicando que no se puede registrar o modificar el detalle ingreso correctamente | Detener operación |
| consultarDetallesIngresoPorFiltro | Permite buscar, listar y filtrar los detalles de ingreso según los criterios de búsqueda enviados | filtro | DetalleIngreso | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<DetalleIngreso> | Contiene la lista de detalles de ingreso que cumplen con las condiciones del filtro enviado | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| ModificarDetalleIngreso | Permite actualizar la información de un detalle de ingreso existente | id | UUID | Tiene el identificador único del detalle de ingreso a modificar y la nueva información | DetalleIngreso | Objeto del detalle de ingreso con su información actualizada | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  | datos | DetalleIngreso |  |  |  | P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | Generar una excepción indicando que  no se puede registrar o modificar el detalle ingreso correctamente | Detener operación |
|  |  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle ingreso con un ingreso inventario con un estado distinto de: "En proceso" | Generar una excepción indicando que ya no es posible modificar o eliminar el detalle de ingreso debido al estado del ingreso | Detener operación |
| eliminarDetalleIngreso | Permite eliminar un detalle ingreso  de un ingreso inventario asociado siempre y cuando no se haya creado | id | UUID | Contiene el identificador único del detalle ingreso que se desea eliminar |  |  | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | Generar una excepción indicando que  no se puede registrar o modificar el detalle ingreso correctamente | Detener operación |
|  |  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle ingreso con un ingreso inventario con un estado distinto de: "En proceso" | Generar una excepción indicando que ya no es posible modificar o eliminar el detalle de ingreso debido al estado del ingreso | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador | Registrar un nuevo detalle de ingreso | Permite registrar un nuevo detalle de ingreso en el sistema | DetalleIngreso | Datos del nuevo detalle de ingreso | Contiene la información requerida para registrar el detalle de ingreso | P-DIN-001 | Asegurar que el id de detalle de ingreso sea único e irrepetible. |  | Detalle de ingreso registrado |  |
|  |  |  |  |  |  | P-DIN-002 | Asegurar que la combinación de la factura de ingreso y el producto-sede sea única e irrepetible |  |  |  |
|  |  |  |  |  |  | P-DIN-003 | Asegurar que la sede asociada a los producto sede ingresados correspondan a la sede que esta asociada con el ingreso inventario respectivo |  |  |  |
|  |  |  |  |  |  | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  |  |  |
|  |  |  |  |  |  | P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo |  |  |  |
| Administrador | Consultar detalles de ingreso por filtro | Permite buscar, listar y filtrar los detalles de ingreso según los criterios de búsqueda enviados | DetalleIngreso | Filtros de detalles de ingreso | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  | Detalles de ingreso encontrados |  |
| Administrador | Modificar un detalle de ingreso | Permite actualizar la información de un detalle de ingreso existente | DetalleIngreso | Datos del detalle de ingreso a modificar | Tiene el identificador único del detalle de ingreso a modificar y la nueva información | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  | Detalle ingreso modificado |  |
|  |  |  |  |  |  | P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo |  |  |  |
|  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle ingreso con un ingreso inventario con un estado distinto de: "En proceso" |  |  |  |
| Administrador | Eliminar un detalle ingreso | Permite eliminar un detalle ingreso de un ingreso inventario asociado siempre y cuadno no se haya creado | DetalleIngreso | Identificador del detalle ingreso a eliminar | Contiene el identificador único del detalle ingreso que se desea eliminar | P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  | Detalle ingreso eliminado |  |
|  |  |  |  |  |  | P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo |  |  |  |
|  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle ingreso con un ingreso inventario con un estado distinto de: "En proceso" |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-DIN-001 | Asegurar que el id de detalle de ingreso sea único e irrepetible. | DetalleIngreso |
| P-DIN-002 | Asegurar que la combinación de la factura de ingreso y el producto-sede sea única e irrepetible | DetalleIngreso |
| P-DIN-003 | Asegurar que la sede asociada a los producto sede ingresados correspondan a la sede que esta asociada con el ingreso inventario respectivo | DetalleIngreso |
| P-DIN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | DetalleIngreso |
| P-DIN-005 | Asegurar que al registrar o modificar un detalle ingreso se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | DetalleIngreso |
| P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle ingreso con un ingreso inventario con un estado distinto de: "En proceso" | DetalleIngreso |

[↑ Volver al índice](#objetos-de-dominio)

---

## DetalleCompra

**Descripción:** Representa el detalle de cada producto que se vendió en una sede específica, su cantidad, precio y demás atributos.  
**Línea de vida:** 7

### Muestreo de datos

- **ID**: Identificador único de la línea de detalle de la compra
- **ProcesoCompra**: Identificación de la compra a la que pertenece el detalle de compra del producto correspondiente
- **ProductoSede**: Hace referencia al producto en su sede correspondiente en la que se realizó la venta
- **Cantidad**: Cantidad de unidades vendidas de ese producto
- **PrecioUnitario**: Precio de venta por unidad en el momento de la compra, en este caso no se referencia ya que aunque cambie el precio del producto en el futuro, este queda permanente en el tiempo
- **Subtotal**: Resultado de cantidad por el precio unitario del producto
- **DetalleCompraUnico**: Combinación única que indica que un mismo producto-sede no puede repetirse en una misma compra

| ID | ProcesoCompra | ProductoSede | Cantidad | PrecioUnitario | Subtotal | DetalleCompraUnico |
|---|---|---|---|---|---|---|
| 1 | 1 | LWFIP14  + Saraitel San Nicolás | 3 | 45000 | 135000 | 1 \|\| LWFIP14  + Saraitel San Nicolás |
| 2 | 2 | VDIP13 + Saraitel San Nicolás | 2 | 35000 | 70000 | 2 \|\| VDIP13 + Saraitel San Nicolás |
| 3 | 3 | TPCIP35w + Saraitel San Antonio | 1 | 70000 | 70000 | 3 \|\| TPCIP35w + Saraitel San Antonio |
| 4 | 4 | AirDots 2 + Saraitel La Ceja | 1 | 90000 | 90000 | 4 \|\| AirDots 2 + Saraitel La Ceja |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarDetalleCompra | consultarDetallesCompraPorFiltro | consultarDetallesCompraPorFiltro | modificarDetalleCompra | modificarDetalleCompra | eliminarDetalleCompra |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la línea de detalle de la compra | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los detalles de compra | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable | Requerido |
| ProcesoCompra | Identificación de la compra a la que pertenece el detalle de compra del producto correspondiente | No | ProcesoCompra | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable | No requerido |
| ProductoSede | Hace referencia al producto en su sede correspondiente en la que se realizó la venta | No | ProductoSede | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable | No Requerido |
| Cantidad | Cantidad de unidades vendidas de ese producto | No | Numérico Entero | Si | - | - | - | - | 1 | - | - | Debe ser un entero mayor que cero y no puede superar el stock disponible del producto en el momento | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | Requerido | Modificable | No Requerido |
| PrecioUnitario | Precio de venta por unidad en el momento de la compra, en este caso no se referencia ya que aunque cambie el precio del producto en el futuro, este queda permanente en el tiempo | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Debe ser un valor positivo o igual a cero,  se toma del precio vigente del producto en la sede al momento de la compra | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar | No requerido | No modificable | No Requerido |
| Subtotal | Resultado de cantidad por el precio unitario del producto | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Es un dato calculado, es la cantidad * valor unitario de la línea, no se ingresa de forma manual; no puede ser negativo. | Si | No | - | No | No | - | - | No | Requerido | No Filtro | Mostrar | No requerido | No modificable | No Requerido |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| DetalleCompraUnico | Combinación única que indica que un mismo producto-sede no puede repetirse en una misma compra | ProcesoCompra |
|  |  | ProductoSede |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |   |
|---|---|---|---|---|---|---|---|---|---|---|---|
| registrarDetalleCompra | Permite registrar un nuevo detalle de compra en el sistema | datos | DetalleCompra | Contiene la información requerida para registrar el detalle de compra | DetalleCompra | Objeto del detalle de compra registrado con su identificador ID asignado, proceso compra y  producto sede respecivos y demás atributos | P-DCO-001 | Asegurar que el id de detalle de compra sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |  |
|  |  |  |  |  |  |  | P-DCO-002 | Asegurar que un mismo ProductoSede no se encuentre repetido dentro de un mismo ProcesoCompra | Generar una excepción indicando que ya existe un producto sede en esa compra | Detener operación |  |
|  |  |  |  |  |  |  | P-DCO-003 | Asegurar que la sede asociada a los producto sede ingresados correspondan a la sede que esta asociada el empleado que atiende la compra | Generar una excepción indicando que el producto sede no pertenece a la sede en la que se realiza la compra | Detener operación |  |
|  |  |  |  |  |  |  | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que no fue posible actualizar el Stock del ProductoSede como consecuencia de la operación realizada sobre el DetalleCompra | Detener operación |  |
|  |  |  |  |  |  |  | P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | Generar una excepción indicando que  no se puede registrar o modificar el detalle compra correctamente | Detener operación |  |
| consultarDetallesCompraPorFiltro | Permite buscar, listar y filtrar los detalles de compra según los criterios de búsqueda enviados | filtro | DetalleCompra | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<DetalleCompra> | Contiene la lista de detalles de compra que cumplen con las condiciones del filtro enviado | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |  |
| modificarDetalleCompra | Permite actualizar la información de un detalle de compra existente | id | UUID | Tiene el identificador único del detalle de compra a modificar y la nueva información | DetalleCompra | Objeto del detalle de compra con su información actualizada | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |  |
|  |  | datos | DetalleCompra |  |  |  | P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | Generar una excepción indicando que  no se puede registrar o modificar el detalle compra correctamente | Detener operación |  |
|  |  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle compra con un proceso de compra con un estado distinto de: "En proceso" | Generar una excepción indicando que ya no es posible modificar o eliminar el detalle de compra debido al estado del proceso de compra | Detener operación |  |
| eliminarDetalleCompra | Permite eliminar un detalle de compra conservando la trazabilidad de su historial | id | UUID | Contiene el identificador único del detalle de compra que se desea eliminar |  |  | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |  |
|  |  |  |  |  |  |  | P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | Generar una excepción indicando que  no se puede registrar o modificar el detalle compra correctamente | Detener operación | #NAME? |
|  |  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle compra con un proceso de compra con un estado distinto de: "En proceso" | Generar una excepción indicando que ya no es posible modificar o eliminar el detalle de compra debido al estado del proceso de compra | Detener operación |  |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo detalle de compra | Permite registrar un nuevo detalle de compra en el sistema | DetalleCompra | Datos del nuevo detalle de compra | Contiene la información requerida para registrar el detalle de compra | P-DCO-001 | Asegurar que el id de detalle de compra sea único e irrepetible |  | Detalle de compra registrado |  |
|  |  |  |  |  |  | P-DCO-002 | Asegurar que un mismo ProductoSede no se encuentre repetido dentro de un mismo ProcesoCompra |  |  |  |
|  |  |  |  |  |  | P-DCO-003 | Asegurar que la sede asociada a los producto sede ingresados correspondan a la sede que esta asociada el empleado que atiende la compra |  |  |  |
|  |  |  |  |  |  | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
|  |  |  |  |  |  | P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo |  |  |  |
| Administrador/Vendedor | Consultar detalles de compra por filtro | Permite buscar, listar y filtrar los detalles de compra según los criterios de búsqueda enviados | DetalleCompra | Filtros de detalles de compra | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-DCO-004 | Asegurar que no se pueda modificar o eliminar un detalle compra con un proceso de compra con un estado distinto de: "En proceso" |  | Detalles de compra encontrados |  |
| Administrador/Vendedor | Modificar un detalle de compra | Permite actualizar la información de un detalle de compra existente | DetalleCompra | Datos del detalle de compra a modificar | Tiene el identificador único del detalle de compra a modificar y la nueva información | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Detalle compra  modificado |  |
|  |  |  |  |  |  | P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo |  |  |  |
|  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle compra con un proceso de compra con un estado distinto de: "En proceso" |  |  |  |
| Administrador/Vendedor | Eliminar un detalle compra | Permite eliminar un detalle compra | DetalleCompra | Identificador del detalle compra a eliminar | Contiene el identificador único del detalle compra que se desea eliminar | P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Detalle compra eliminado |  |
|  |  |  |  |  |  | P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo |  |  |  |
|  |  |  |  |  |  | P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle compra con un proceso de compra con un estado distinto de: "En proceso" |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-DCO-001 | Asegurar que el id de detalle de compra sea único e irrepetible | DetalleCompra |
| P-DCO-002 | Asegurar que un mismo ProductoSede no se encuentre repetido dentro de un mismo ProcesoCompra | DetalleCompra |
| P-DCO-003 | Asegurar que la sede asociada a los producto sede ingresados correspondan a la sede que esta asociada el empleado que atiende la compra | DetalleCompra |
| P-DCO-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | DetalleCompra |
| P-DCO-005 | Asegurar que al registrar o modificar un detalle compra se actualice la cantidad de stock de producto sede correspondiente al procedimiento que se hizo | DetalleCompra |
| P-DIN-006 | Asegurar que no se pueda modificar o eliminar un detalle compra con un proceso de compra con un estado distinto de: "En proceso" | DetalleIngreso |

[↑ Volver al índice](#objetos-de-dominio)

---

## Compra

**Descripción:** Representa la transacción en la que un cliente adquiere uno o varios productos en una sede, es atendida por un empleado.  
**Línea de vida:** 7

### Muestreo de datos

- **ID**: Identificador único de la compra
- **ProcesoCompra**: Proceso de compra asociado a la compra.
- **FechaCompra**: Fecha en que se realiza la compra
- **Estado**: Estado actual de la compra (Pendiente, Pagado y Anulado)
- **ProcesoCompraUnico**: Combinación única que indica que no puede existir más de un proceso compra que genere una misma compra

| ID | ProcesoCompra | FechaCompra | Estado | ProcesoCompraUnico |
|---|---|---|---|---|
| 1 | 1 | 01/02/2026 - 9:02 am | Pendiente | 1 |
| 2 | 2 | 02/02/2026 - 11:15 am | Pendiente | 2 |
| 3 | 3 | 15/02/2026 - 2:30 pm | Pagado | 3 |
| 4 | 4 | 04/03/2026 - 8:00 pm | Anulado | 4 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarCompra | consultarComprasPorFiltro | consultarComprasPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la compra | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las compras | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| ProcesoCompra | Proceso de compra asociado a la compra. | No | ProcesoCompra | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| FechaCompra | Fecha en que se realiza la compra | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA   HH:MM | No puede ser una fecha posterior a la fecha y hora actual del sistema, es igual a la fecha de actualización de su respectivo ProcesoCompra cuando su estado fue Creado | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |
| Estado | Estado actual de la compra (Pendiente, Pagado y Anulado) | No | Texto | Si | 6 | 12 | - | - | - | - | - | Solo puede tomar los estados definidos para la compra y sus cambios deben realizarse de acuerdo con las transiciones permitidas por el proceso de compra. | No | No | - | Si | Si | - | Pendiente | Si | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| ProcesoCompraUnico | Combinación única que indica que no puede existir más de un proceso compra que genere una misma compra | ProcesoCompra |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarCompra | Permite registrar una nueva compra en el sistema | datos | Compra | Contiene la información requerida para registrar la compra | Compra | Objeto de la compra registrada con su identificador ID asignado, proceso compra respectivo, fecha compra y estado | P-COM-001 | Asegurar que el ID de la compra sea único e irrepetible. | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-COM-002 | Asegurar que un mismo proceso de compra no genere más de una compra asociada | Generar una excepción indicando que ya existe una compra con el mismo ProcesoCompra. | Detener operación |
|  |  |  |  |  |  |  | P-COM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
|  |  |  |  |  |  |  | P-COM-005 | Asegurar que una compra se cree si y solo si el proceso compra ya fue creado (Estado: Creado) | Generar una excepción indicando que solo se puede crear una Compra a partir de un ProcesoCompra en estado Creado | Detener operación |
| consultarComprasPorFiltro | Permite buscar, listar y filtrar las compras según los criterios de búsqueda enviados | filtro | Compra | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Compra> | Contiene la lista de compras que cumplen con las condiciones del filtro enviado | P-COM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar una nueva compra | Permite registrar una nueva compra en el sistema | Compra | Datos de la nueva compra | Contiene la información requerida para registrar la compra | P-COM-001 | Asegurar que el ID de la compra sea único e irrepetible. |  | Compra registrada |  |
|  |  |  |  |  |  | P-COM-002 | Asegurar que un mismo proceso de compra no genere más de una compra asociada |  |  |  |
|  |  |  |  |  |  | P-COM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  |  |  |
|  |  |  |  |  |  | #REF! | #REF! |  |  |  |
|  |  |  |  |  |  | P-COM-005 | Asegurar que una compra se cree si y solo si el proceso compra ya fue creado (Estado: Creado) |  |  |  |
| Administrador/Vendedor | Consultar compras por filtro | Permite buscar, listar y filtrar las compras según los criterios de búsqueda enviados | Compra | Filtros de compras | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-COM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. |  | Compras encontradas |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-COM-001 | Asegurar que el ID de la compra sea único e irrepetible. | Compra |
| P-COM-002 | Asegurar que un mismo proceso de compra no genere más de una compra asociada | Compra |
| P-COM-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato. | Compra |
| P-COM-005 | Asegurar que una compra se cree si y solo si el proceso compra ya fue creado (Estado: Creado) | Compra |

[↑ Volver al índice](#objetos-de-dominio)

---

## Pago

**Descripción:** Representa el abono que realiza el cliente para saldar una compra.  
**Línea de vida:** 8

### Muestreo de datos

- **ID**: Identificador único del pago
- **Compra**: Identificación de la compra que se está saldando
- **MontoPendiente**: Valor abonado por el cliente en este pago
- **FechaPago**: Fecha en que se realiza el abono
- **CompraUnica**: Combinación única que indica que no puede existir más de una compra para realizar su respectivo pago

| ID | Compra | MontoPendiente | FechaPago | CompraUnica |
|---|---|---|---|---|
| 1 | 1 | 100000 | 01/02/2026 - 9:02 am | 1 |
| 2 | 2 | 70000 | 02/02/2026 - 11:15 am | 2 |
| 3 | 3 | 35000 | 15/02/2026 - 2:30 pm | 3 |
| 4 | 4 | 135000 | 04/03/2026 - 7:00 pm | 4 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarPago | consultarPagosPorFiltro | consultarPagosPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del pago | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los pagos | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Compra | Identificación de la compra que se está saldando | No | Compra | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| MontoPendiente | Valor abonado por el cliente en este pago | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Se autogenera con respecto al total de la compra en proceso compra y se calcula con respecto a (monto pendiente - monto usado) en algun pago para saldarlo; no puede ser negativo. | Si | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |
| FechaPago | Fecha en que se realiza el abono | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA   HH:MM | No puede ser una fecha posterior a la fecha y hora actual del sistema, ni menor a la fecha en la que se genero la compra | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| CompraUnica | Combinación única que indica que no puede existir más de una compra para realizar su respectivo pago | Compra |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarPago | Permite registrar un nuevo pago en el sistema | datos | Pago | Contiene la información requerida para registrar el pago | Pago | Objeto del pago registrado con su identificador ID asignado | P-PAG-001 | Asegurar que el id de pago deba ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-PAG-002 | Asegurar que el campo Compra de pago sea único e irrepetible, es decir, la compra solo puede pertenecer a un pago | Generar una excepción indicando que ya existe un pago para esa misma Compra | Detener operación |
|  |  |  |  |  |  |  | P-PAG-003 | Asegurar que solo pueda registrarse un Pago para una Compra en estado Pendiente | Generar una excepción indicando que la compra fue anulada o cancelada y ya no se puede pagar | Detener operación |
|  |  |  |  |  |  |  | P-PAG-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarPagosPorFiltro | Permite buscar, listar y filtrar los pagos según los criterios de búsqueda enviados | filtro | Pago | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Pago> | Contiene la lista de pagos que cumplen con las condiciones del filtro enviado | P-PAG-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo pago | Permite registrar un nuevo pago en el sistema | Pago | Datos del nuevo pago | Contiene la información requerida para registrar el pago | P-PAG-001 | Asegurar que el id de pago deba ser único e irrepetible |  | Pago registrado |  |
|  |  |  |  |  |  | P-PAG-002 | Asegurar que el campo Compra de pago sea único e irrepetible, es decir, la compra solo puede pertenecer a un pago |  |  |  |
|  |  |  |  |  |  | P-PAG-003 | Asegurar que solo pueda registrarse un Pago para una Compra en estado Pendiente |  |  |  |
|  |  |  |  |  |  | P-PAG-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar pagos por filtro | Permite buscar, listar y filtrar los pagos según los criterios de búsqueda enviados | Pago | Filtros de pagos | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-PAG-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Pagos encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PAG-001 | Asegurar que el id de pago deba ser único e irrepetible | Pago |
| P-PAG-002 | Asegurar que el campo Compra de pago sea único e irrepetible, es decir, la compra solo puede pertenecer a un pago | Pago |
| P-PAG-003 | Asegurar que solo pueda registrarse un Pago para una Compra en estado Pendiente | Pago |
| P-PAG-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Pago |

[↑ Volver al índice](#objetos-de-dominio)

---

## Factura

**Descripción:** Representa el comprobante legal de venta que se genera a partir de una compra ya pagada  
**Línea de vida:** 8

### Muestreo de datos

- **ID**: Identificador único de la factura
- **Compra**: Identificación de la compra con la que se hace la factura
- **FechaEmision**: Fecha en que se emite la factura
- **FacturaCompraUnica**: Combinación única que indica que no puede existir más de una factura con la misma referencia de compra

| ID | Compra | FechaEmision | FacturaCompraUnica |
|---|---|---|---|
| 1 | 1 | 01/02/2026 - 9:02 am | 1 |
| 2 | 2 | 02/02/2026 - 11:15 am | 2 |
| 3 | 3 | 15/02/2026 - 2:30 pm | 3 |
| 4 | 4 | 04/03/2026 - 7:00 pm | 4 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarFactura | consultarFacturasPorFiltro | consultarFacturasPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la factura | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las facturas | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Compra | Identificación de la compra con la que se hace la factura | No | Compra | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| FechaEmision | Fecha en que se emite la factura | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA   HH:MM | No puede ser una fecha posterior a la fecha y hora actual del sistema ni menor a la fecha en la que se hizo la compra | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| FacturaCompraUnica | Combinación única que indica que no puede existir más de una factura con la misma referencia de compra | Compra |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarFactura | Permite registrar una nueva factura en el sistema | datos | Factura | Contiene la información requerida para registrar la factura | Factura | Objeto de la factura registrada con su identificador ID asignado | P-FAC-001 | Asegurar que el id de la factura debe ser único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-FAC-002 | Asegurar que el campo Compra de factura debe ser único e irrepetible, es decir, solo existe una factura por compra | Generar una excepción indicando que ya existe una factura con ese mismo Compra | Detener operación |
|  |  |  |  |  |  |  | P-FAC-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarFacturasPorFiltro | Permite buscar, listar y filtrar las facturas según los criterios de búsqueda enviados | filtro | Factura | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Factura> | Contiene la lista de facturas que cumplen con las condiciones del filtro enviado | P-FAC-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar una nueva factura | Permite registrar una nueva factura en el sistema | Factura | Datos de la nueva factura | Contiene la información requerida para registrar la factura | P-FAC-001 | Asegurar que el id de la factura debe ser único e irrepetible |  | Factura registrada |  |
|  |  |  |  |  |  | P-FAC-002 | Asegurar que el campo Compra de factura debe ser único e irrepetible, es decir, solo existe una factura por compra |  |  |  |
|  |  |  |  |  |  | P-FAC-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar facturas por filtro | Permite buscar, listar y filtrar las facturas según los criterios de búsqueda enviados | Factura | Filtros de facturas | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-FAC-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Facturas encontradas |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-FAC-001 | Asegurar que el id de la factura debe ser único e irrepetible | Factura |
| P-FAC-002 | Asegurar que el campo Compra de factura debe ser único e irrepetible, es decir, solo existe una factura por compra | Factura |
| P-FAC-003 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Factura |

[↑ Volver al índice](#objetos-de-dominio)

---

## Devolución

**Descripción:** Representa la solicitud de un cliente de devolver un producto si cumple con las condiciones establecidas en el negocio.  
**Línea de vida:** 8

### Muestreo de datos

- **ID**: Identificador único de la devolución
- **DetalleCompra**: Producto comprado que el cliente desea devolver
- **Motivo**: Motivo o razón por la cual el cliente devuelve el producto
- **FechaDevolucion**: Fecha en que el cliente solicita la devolución
- **Cantidad**: Cantidad de productos que el cliente desea devolver
- **MontoDevolución**: Monto específico de la devolucion con la cantidad del producto y su precio unitario en su detalleCompra
- **Estado**: Estado actual de la solicitud de devolución (Pendiente, Aprobada, Rechazada)
- **DevolucionFechaUnica**: Combinación única que indica que no se puede repetir una misma referencia a detalle compra en la misma fecha

| ID | DetalleCompra | Motivo | FechaDevolucion | Cantidad | MontoDevolución | Estado | DevolucionFechaUnica |
|---|---|---|---|---|---|---|---|
| 1 | 1 \|\| LWFIP14  + Saraitel San Nicolás | Garantía | 01/02/2026 - 9:02 am | 2 | 90000 | Pendiente | 1 \|\| LWFIP14  + Saraitel San Nicolás + 01/02/2026 - 9:02 am |
| 2 | 2 \|\| VDIP13 + Saraitel San Nicolás | Cambio de opinión | 02/02/2026 - 11:15 am | 1 | 35000 | Pendiente | 2 \|\| VDIP13 + Saraitel San Nicolás + 02/02/2026 - 11:15 am |
| 3 | 3 \|\| TPCIP35w + Saraitel San Antonio | Producto incorrecto | 15/02/2026 - 2:30 pm | 3 | 210000 | Aprobada | 3 \|\| TPCIP35w + Saraitel San Antonio + 15/02/2026 - 2:30 pm |
| 4 | 4 \|\| AirDots 2 + Saraitel La Ceja | Referencia incorrecta | 05/09/2026 - 12:50 pm | 5 | 450000 | Rechazada | 4 \|\| AirDots 2 + Saraitel La Ceja + 05/09/2026 - 12:50 pm |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarDevolucion | consultarDevolucionesPorFiltro | consultarDevolucionesPorFiltro | modificarDevolucion | modificarDevolucion |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la devolución | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las devoluciones | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar | Requerido | No modificable |
| DetalleCompra | Producto comprado que el cliente desea devolver | No | DetalleCompra | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable |
| Motivo | Motivo o razón por la cual el cliente devuelve el producto | No | Motivo | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | Modificable |
| FechaDevolucion | Fecha en que el cliente solicita la devolución | No | Fecha/Hora | Si | - | - | - | - | - | - | DD-MM-AAAA   HH:MM | No puede ser una fecha posterior a la fecha y hora actual del sistema ni inferior a la fecha en que se realizo la compra | No | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar | No requerido | No modificable |
| Cantidad | Cantidad de productos que el cliente desea devolver | No | Numérico Entero | Si | - | - | - | - | 1 | - | - | Debe ser un entero mayor que cero y no puede superar la cantidad de productos que se compraron en detalleCompra | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | Modificable |
| MontoDevolucion | Monto específico de la devolucion con la cantidad del producto y su precio unitario en su detalleCompra | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Es un dato calculado, es la cantidad * valor unitario del producto en su detalle compra específico; no se ingresa de forma manual, y debe ser mayor a cero | Si | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar | No requerido | No modificable |
| Estado | Estado actual de la solicitud de devolución (Pendiente, Aprobada, Rechazada) | No | Texto | Si | 8 | 9 | - | - | - | - | - | Solo admite los valores Pendiente, Aprobada o Rechazada; cualquier otro valor debe rechazarse | No | No | - | Si | Si | - | Pendiente | Si | Requerido | Filtro | Mostrar | No requerido | No modificable |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| DevolucionFechaUnica | Combinación única que indica que no se puede repetir una misma referencia a detalle compra en la misma fecha | DetalleCompra |
|  |  | FechaDevolucion |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarDevolucion | Permite registrar una nueva devolución en el sistema | datos | Devolución | Contiene la información requerida para registrar la devolución | Devolución | Objeto de la devolución registrada con su identificador ID asignado | P-DEV-001 | Asegurar que el id de devolución sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-DEV-002 | Asegurar que no exista más de una Devolución asociada al mismo DetalleCompra en la misma fecha y hora de solicitud | a existe una Devolución asociada al mismo DetalleCompra en la misma fecha y hora | Detener operación |
|  |  |  |  |  |  |  | P-DEV-003 | Asegurar que la cantidad solicitada de devolución, no supere la cantidad real del detalle de compra | Generar una excepción indicando que la cantidad solicitada para la devolución no puede superar la cantidad real establecida en el detalle de compra | Detener operación |
|  |  |  |  |  |  |  | P-DEV-004 | Asegurar que una Devolución aprobada por motivo Garantía incremente el StockGarantía del ProductoSede correspondiente según la cantidad devuelta | Generar una excepción indicando que no fue posible procesar el incremento automático del StockGarantía en el ProductoSede correspondiente para la devolución aprobada por garantía | Detener operación |
|  |  |  |  |  |  |  | P-DEV-005 | Asegurar que una Devolución aprobada por cualquier motivo distinto de garantía incremente el Stock del ProductoSede correspondiente según la cantidad devuelta | Generar una excepción indicando que no fue posible procesar el incremento automático del Stock en el ProductoSede correspondiente para la devolución aprobada | Detener operación |
|  |  |  |  |  |  |  | P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarDevolucionesPorFiltro | Permite buscar, listar y filtrar las devoluciones según los criterios de búsqueda enviados | filtro | Devolución | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<Devolución> | Contiene la lista de devoluciones que cumplen con las condiciones del filtro enviado | P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| modificarDevolucion | Permite actualizar la información de una devolución existente | datos | Devolución | Tiene el identificador único de la devolución a modificar y la nueva información | Devolución | Objeto de la devolución con su información actualizada | P-DEV-003 | Asegurar que la cantidad solicitada de devolución, no supere la cantidad real del detalle de compra | Generar una excepción indicando que la cantidad solicitada para la devolución no puede superar la cantidad real establecida en el detalle de compra | Detener operación |
|  |  |  |  |  |  |  | P-DEV-004 | Asegurar que una Devolución aprobada por motivo Garantía incremente el StockGarantía del ProductoSede correspondiente según la cantidad devuelta | Generar una excepción indicando que no fue posible procesar el incremento automático del StockGarantía en el ProductoSede correspondiente para la devolución aprobada por garantía | Detener operación |
|  |  |  |  |  |  |  | P-DEV-005 | Asegurar que una Devolución aprobada por cualquier motivo distinto de garantía incremente el Stock del ProductoSede correspondiente según la cantidad devuelta | Generar una excepción indicando que no fue posible procesar el incremento automático del Stock en el ProductoSede correspondiente para la devolución aprobada | Detener operación |
|  |  |  |  |  |  |  | P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar una nueva devolución | Permite registrar una nueva devolución en el sistema | Devolucion | Datos de la nueva devolución | Contiene la información requerida para registrar la devolución | P-DEV-001 | Asegurar que el id de devolución sea único e irrepetible |  | Devolución registrada |  |
|  |  |  |  |  |  | P-DEV-002 | Asegurar que no exista más de una Devolución asociada al mismo DetalleCompra en la misma fecha y hora de solicitud |  |  |  |
|  |  |  |  |  |  | P-DEV-003 | Asegurar que la cantidad solicitada de devolución, no supere la cantidad real del detalle de compra |  |  |  |
|  |  |  |  |  |  | P-DEV-004 | Asegurar que una Devolución aprobada por motivo Garantía incremente el StockGarantía del ProductoSede correspondiente según la cantidad devuelta |  |  |  |
|  |  |  |  |  |  | P-DEV-005 | Asegurar que una Devolución aprobada por cualquier motivo distinto de garantía incremente el Stock del ProductoSede correspondiente según la cantidad devuelta |  |  |  |
|  |  |  |  |  |  | P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar devoluciones por filtro | Permite buscar, listar y filtrar las devoluciones según los criterios de búsqueda enviados | Devolucion | Filtros de devoluciones | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Devoluciones encontradas |  |
| Administrador/Vendedor | Modificar una devolución | Permite actualizar la información de una devolución existente | Devolucion | Datos de la devolución a modificar | Tiene el identificador único de la devolución a modificar y la nueva información | P-DEV-003 | Asegurar que la cantidad solicitada de devolución, no supere la cantidad real del detalle de compra |  | Devolución modificada |  |
|  |  |  |  |  |  | P-DEV-004 | Asegurar que una Devolución aprobada por motivo Garantía incremente el StockGarantía del ProductoSede correspondiente según la cantidad devuelta |  |  |  |
|  |  |  |  |  |  | P-DEV-005 | Asegurar que una Devolución aprobada por cualquier motivo distinto de garantía incremente el Stock del ProductoSede correspondiente según la cantidad devuelta |  |  |  |
|  |  |  |  |  |  | P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-DEV-001 | Asegurar que el id de devolución sea único e irrepetible | Devolucion |
| P-DEV-002 | Asegurar que no exista más de una Devolución asociada al mismo DetalleCompra en la misma fecha y hora de solicitud | Devolucion |
| P-DEV-003 | Asegurar que la cantidad solicitada de devolución, no supere la cantidad real del detalle de compra | Devolucion |
| P-DEV-004 | Asegurar que una Devolución aprobada por motivo Garantía incremente el StockGarantía del ProductoSede correspondiente según la cantidad devuelta | Devolucion |
| P-DEV-005 | Asegurar que una Devolución aprobada por cualquier motivo distinto de garantía incremente el Stock del ProductoSede correspondiente según la cantidad devuelta | Devolucion |
| P-DEV-006 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Devolucion |

[↑ Volver al índice](#objetos-de-dominio)

---

## PagoNormal

**Descripción:** Representa la especialización del pago realizado directamente por el cliente mediante un método de pago  
**Línea de vida:** 9

### Muestreo de datos

- **ID**: Identificador único del pago normal
- **MetodoPago**: Método de pago utilizado para realizar el pago normal
- **Pago**: Pago base asociado a la transacción realizada
- **MontoPagar**: Indica la cantidad de dinero que se va a relizar en este pago
- **MetodoPagoUnico**: Combinación única que indica que no puede repetirse un mismo metodo de pago para un mismo pago

| ID | MetodoPago | Pago | MontoPagar | MetodoPagoUnico |
|---|---|---|---|---|
| 1 | Efectivo | 1 | 125000 | 1 + Efectivo |
| 2 | Tarjeta Débito | 2 | 348500 | 2 + Tarjeta Débito |
| 3 | Tarjeta Crédito | 3 | 78600 | 3 + Tarjeta Crédito |
| 4 | Nequi | 4 | 215900 | 4 + Nequi |
| 5 | Transferencia Bancaria | 1 | 459000 | 1 + Transferencia Bancaria |
| 6 | Wompi | 2 | 98250 | 2 + Wompi |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarPagoNormal | consultarPagosNormalesPorFiltro | consultarPagosNormalesPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del pago normal | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los pagos normales | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| MetodoPago | Método de pago utilizado para realizar el pago normal | No | MetodoPago | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| Pago | Pago base asociado a la transacción realizada | No | Pago | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| MontoPagar | Indica la cantidad de dinero que se va a relizar en este pago | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 |  | Formato contaduría | Dato que se ingresa por el empleado, este no puede ser mayor o igual al monto faltante para realizar la compra, debe ser mayor a cero | No | No | - | No | No | . | . | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| MetodoPagoUnico | Combinación única que indica que no puede repetirse un mismo metodo de pago para un mismo pago | MetodoPago |
|  |  | Pago |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarPagoNormal | Permite registrar un nuevo pago normal en el sistema | datos | PagoNormal | Contiene la información requerida para registrar el pago normal | PagoNormal | Objeto del pago normal registrado con su identificador ID asignado | P-PGN-001 | Asegurar que el id de pago normal sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-PGN-002 | Asegurar que un pago normal solo pueda usar una vez un mismo metodo de pago | Generar una excepción indicando que ya existe un pago normal con ese mismo MetodoPago | Detener operación |
|  |  |  |  |  |  |  | P-PGN-003 | Asegurar que el monto a pagar sea menor que el monto pendiente de la compra | Generar una excepción indicando que el monto no puede ser mayor al monto pendiente a pagar | Detener operación |
|  |  |  |  |  |  |  | P-PGN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarPagosNormalesPorFiltro | Permite buscar, listar y filtrar los pagos normales según los criterios de búsqueda enviados | filtro | PagoNormal | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<PagoNormal> | Contiene la lista de pagos normales que cumplen con las condiciones del filtro enviado | P-PGN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo pago normal | Permite registrar un nuevo pago normal en el sistema | PagoNormal | Datos del nuevo pago normal | Contiene la información requerida para registrar el pago normal | P-PGN-001 | Asegurar que el id de pago normal sea único e irrepetible |  | Pago normal registrado |  |
|  |  |  |  |  |  | P-PGN-002 | Asegurar que un pago normal solo pueda usar una vez un mismo metodo de pago |  |  |  |
|  |  |  |  |  |  | P-PGN-003 | Asegurar que el monto a pagar sea menor que el monto pendiente de la compra |  |  |  |
|  |  |  |  |  |  | P-PGN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar pagos normales por filtro | Permite buscar, listar y filtrar los pagos normales según los criterios de búsqueda enviados | PagoNormal | Filtros de pagos normales | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-PGN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Pagos normales encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-PGN-001 | Asegurar que el id de pago normal sea único e irrepetible | PagoNormal |
| P-PGN-002 | Asegurar que un pago normal solo pueda usar una vez un mismo metodo de pago | PagoNormal |
| P-PGN-003 | Asegurar que el monto a pagar sea menor que el monto pendiente de la compra | PagoNormal |
| P-PGN-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | PagoNormal |

[↑ Volver al índice](#objetos-de-dominio)

---

## SaldoFavor

**Descripción:** Representa el saldo a favor del cliente generado por una devolución de mercancía.  
**Línea de vida:** 9

### Muestreo de datos

- **ID**: Identificador único del saldo a favor
- **Devolución**: Referencia a la devolución que generó el saldo a favor
- **MontoDisponible**: Monto del saldo a favor que aún queda disponible para que el cliente lo use en nuevos pagos
- **Estado**: Estado actual del saldo (Disponible,  Aplicado y Anulado)
- **SaldoFavorUnico**: Combinación única que indica que no se puede existir la misma devolucion mas de una vez

| ID | Devolución | MontoDisponible | Estado | SaldoFavorUnico |
|---|---|---|---|---|
| 1 | 1 | 90000 | Disponible | 1 |
| 2 | 2 | 0 | Aplicado | 2 |
| 3 | 3 | 10000 | Anulado | 3 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarSaldoFavor | consultarSaldosFavorPorFiltro | consultarSaldosFavorPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único del saldo a favor | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de los saldos a favor | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| Devolución | Referencia a la devolución que generó el saldo a favor | No | Devolución | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| MontoDisponible | Monto del saldo a favor que aún queda disponible para que el cliente lo use en nuevos pagos | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Se genera a partir del atributo monto inicial de devolucion y se calcula como el monto disponible menos la suma de las aplicaciones de saldo; nunca puede ser negativo | Si | No | - | No | No | - | - | Si | Requerido | Filtro | Mostrar |
| Estado | Estado actual del saldo (Disponible,  Aplicado y Anulado) | No | Texto | Si | 7 | 10 | - | - | - | - | - | Solo admite los valores DISPONIBLE, APLICADO o ANULADO; cualquier otro valor debe rechazarse, APLICADO se origina cuando se gasto todo el montoDisponible y ANULADO se origina cuando pasaron mas de 15 días desde su creación | No | No | - | Si | Si | - | Disponible | Si | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| SaldoFavorUnico | Combinación única que indica que no se puede existir la misma devolucion mas de una vez | Devolución |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarSaldoFavor | Permite registrar un nuevo saldo a favor en el sistema | datos | SaldoFavor | Contiene la información requerida para registrar el saldo a favor | SaldoFavor | Objeto del saldo a favor registrado con su identificador ID asignado | P-SAL-001 | Asegurar que el id de saldo a favor sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-SAL-002 | Asegurar que solo pueda existir una devolución asociada por cada saldo a favor correspondiente | Generar una excepción indicando que ya existe un saldo a favor con ese mismo Devolución | Detener operación |
|  |  |  |  |  |  |  | P-SAL-003 | Asegurar que un SaldoFavor no pueda ser utilizado cuando se encuentre en estado Aplicado o Anulado o han pasado 15 días desde la creacion del mismo (anulado) | Generar una excepción indicando que el saldoFavor ya no puede usarse debido al cambio de estado | Actualizar Estado |
|  |  |  |  |  |  |  | P-SAL-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |
| consultarSaldosFavorPorFiltro | Permite buscar, listar y filtrar los saldos a favor según los criterios de búsqueda enviados | filtro | SaldoFavor | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<SaldoFavor> | Contiene la lista de saldos a favor que cumplen con las condiciones del filtro enviado | P-SAL-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar un nuevo saldo a favor | Permite registrar un nuevo saldo a favor en el sistema | SaldoFavor | Datos del nuevo saldo a favor | Contiene la información requerida para registrar el saldo a favor | P-SAL-001 | Asegurar que el id de saldo a favor sea único e irrepetible |  | Saldo a favor registrado |  |
|  |  |  |  |  |  | P-SAL-002 | Asegurar que solo pueda existir una devolución asociada por cada saldo a favor correspondiente |  |  |  |
|  |  |  |  |  |  | P-SAL-003 | Asegurar que un SaldoFavor no pueda ser utilizado cuando se encuentre en estado Aplicado o Anulado o han pasado 15 días desde la creacion del mismo (anulado) |  |  |  |
|  |  |  |  |  |  | P-SAL-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  |  |  |
| Administrador/Vendedor | Consultar saldos a favor por filtro | Permite buscar, listar y filtrar los saldos a favor según los criterios de búsqueda enviados | SaldoFavor | Filtros saldos a favor | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-SAL-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato |  | Saldos a favor encontrados |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-SAL-001 | Asegurar que el id de saldo a favor sea único e irrepetible | SaldoFavor |
| P-SAL-002 | Asegurar que solo pueda existir una devolución asociada por cada saldo a favor correspondiente | SaldoFavor |
| P-SAL-003 | Asegurar que un SaldoFavor no pueda ser utilizado cuando se encuentre en estado Aplicado o Anulado o han pasado 15 días desde la creacion del mismo (anulado) | SaldoFavor |
| P-SAL-004 | Asegurar que los datos requeridos sean válidos en tipo de dato, longitud, obligatoriedad y formato | SaldoFavor |

[↑ Volver al índice](#objetos-de-dominio)

---

## AplicacionSaldo

**Descripción:** Representa el uso de un saldo a favor sobre un pago con saldo, y permite controlar el saldo de un cliente específico.  
**Línea de vida:** 10

### Muestreo de datos

- **ID**: Identificador único de la aplicación de saldo
- **SaldoFavor**: Referencia al saldo a favor del cliente del cual se toma el monto que se aplica
- **Pago**: Referencia al pago sobre el cual se aplica el saldo a favor
- **ValorAplicado**: Monto del saldo a favor que se aplica en este pago
- **AplicacionSaldoUnica**: Combinación única que indica que no puede aplicarse mas de una vez un mismo saldo a favor sobre el mismo pago

| ID | SaldoFavor | Pago | ValorAplicado | AplicacionSaldoUnica |
|---|---|---|---|---|
| 1 | 1 | 2 | 10000 | 1 \|\| 2 |
| 2 | 2 | 2 | 10000 | 2 \|\| 2 |
| 3 | 3 | 4 | 20000 | 3 \|\| 4 |

### Caracterización

| Nombre atributo | Descripción atributo | Identificador del objeto de dominio | Tipo de dato | Obligatorio | Longitud mínima (si aplica) | Longitud máxima (si aplica) | Precisión (si aplica) | Redondeo (si aplica) | Rango inicial (si aplica) | Rango final (si aplica) | Formato (si aplica) | Reglas especiales (si aplica) | Dato calculado | Aplica ajuste del dato (si aplica) | Carácter de ajuste (si aplica) | Quitar espacios en blanco al inicio (si aplica) | Quitar espacios en blanco al fin (si aplica) | Dato sensible (si aplica) | Valor por defecto (si aplica) | Auto generado | registrarAplicacionSaldo | consultarAplicacionesSaldoPorFiltro | consultarAplicacionesSaldoPorFiltro |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | Identificador único de la aplicación de saldo | Si | Identificador único universal | Si | - | - | - | - | - | - | - | Debe ser único y no debe repetirse en los distintos id's de las aplicaciones de saldo | No | No | - | No | No | - | - | Si | Requerido | Filtro | No Mostrar |
| SaldoFavor | Referencia al saldo a favor del cliente del cual se toma el monto que se aplica | No | SaldoFavor | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| Pago | Referencia al pago sobre el cual se aplica el saldo a favor | No | Pago | Si | - | - | - | - | - | - | - | Aplican las reglas del objeto referenciado | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |
| ValorAplicado | Monto del saldo a favor que se aplica en este pago | No | Numérico Decimal | Si | - | - | 2 | Truncamiento | 0 | - | Formato Contaduria | Es ingresado por el empleado, debe ser mayor que 0 y no puede superar el monto disponible del saldo a favor ni el monto pendiente del pago | No | No | - | No | No | - | - | No | Requerido | Filtro | Mostrar |

| Nombre combinación única | Descripción | Atributos involucrados |
|---|---|---|
| AplicacionSaldoUnica | Combinación única que indica que no puede aplicarse mas de una vez un mismo saldo a favor sobre el mismo pago | SaldoFavor |
|  |  | Pago |

| Responsabilidad | Descripción | Entradas / Parámetro | Entradas / Tipo de dato | Entradas / Descripción | Salida / Tipo de Dato | Salida / Descripción | Políticas (Reglas de Negocio) / Política | Políticas (Reglas de Negocio) / Descripción | Excepción / Detalle | Excepción / ¿Qué hago? |
|---|---|---|---|---|---|---|---|---|---|---|
| registrarAplicacionSaldo | Permite registrar una nueva aplicación de saldo en el sistema | datos | AplicacionSaldo | Contiene la información requerida para registrar la aplicación de saldo | AplicacionSaldo | Objeto de la aplicación de saldo registrada con su identificador ID asignado | P-APS-001 | Asegurar que el id de la aplicación de saldo sea único e irrepetible | Generar un nuevo identificador hasta garantizar que no exista | Continuar operación |
|  |  |  |  |  |  |  | P-APS-002 | Asegurar que un saldo favor solo se use una vez en un pago específico (se puede usar varias veces en distintos pagos) | Generar una excepción indicando que ya existe una aplicación de saldo con esa misma combinación de un mismo saldo a favor para el mismo pago | Detener operación |
|  |  |  |  |  |  |  | P-APS-003 | Asegurar que el valor aplicado no sobrepase el monto pendiente para pagar la compra | Generar una excepción indicando que no se puede superar el monto pendiente de la compra | Detener operación |
|  |  |  |  |  |  |  | P-APS-004 | Asegurar que el valor aplicado no sobrepase el monto disponible del saldo a favor asociado al cliente | Generar una excepción indicando que no se puede superar el monto disponible del saldo disponible a favor | Detener operación |
|  |  |  |  |  |  |  | P-APS-005 | Asegurar que los datos requeridos de la aplicación de saldo sean válidos en tipo de dato, obligatoriedad, longitud y formato | Generar una excepción indicando que los datos requeridos son inválidos, están incompletos | Detener operación |
| consultarAplicacionesSaldoPorFiltro | Permite buscar, listar y filtrar las aplicaciones de saldo según los criterios de búsqueda enviados | filtro | AplicacionSaldo | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | Lista<AplicacionSaldo> | Contiene la lista de aplicaciones de saldo que cumplen con las condiciones del filtro enviado | P-APS-005 | Asegurar que los datos requeridos de la aplicación de saldo sean válidos en tipo de dato, obligatoriedad, longitud y formato | Generar una excepción indicando que los datos requeridos son inválidos o están incompletos | Detener operación |

### Event Storming

| Actor | Action/Command / Acción | Action/Command / Descripción | Entity/Aggregate/Object domain / Objeto de dominio | Read Model / Información externa / Información | Read Model / Información externa / Descripción | Business Rule/Policy / Políticas / Número | Business Rule/Policy / Políticas / Descripción | External System / Sistema Externo | Domain Event / Evento | Hotspot/questions/Risk / Aspectos por solucionar |
|---|---|---|---|---|---|---|---|---|---|---|
| Administrador/Vendedor | Registrar una nueva aplicación de saldo | Permite registrar una nueva aplicación de saldo en el sistema | AplicacionSaldo | Datos de la nueva aplicación de saldo | Contiene la información requerida para registrar la aplicación de saldo | P-APS-001 | Asegurar que el id de la aplicación de saldo sea único e irrepetible |  | Aplicación de saldo registrada |  |
|  |  |  |  |  |  | P-APS-002 | Asegurar que un saldo favor solo se use una vez en un pago específico (se puede usar varias veces en distintos pagos) |  |  |  |
|  |  |  |  |  |  | P-APS-003 | Asegurar que el valor aplicado no sobrepase el monto pendiente para pagar la compra |  |  |  |
|  |  |  |  |  |  | P-APS-004 | Asegurar que el valor aplicado no sobrepase el monto disponible del saldo a favor asociado al cliente |  |  |  |
|  |  |  |  |  |  | P-APS-005 | Asegurar que los datos requeridos de la aplicación de saldo sean válidos en tipo de dato, obligatoriedad, longitud y formato |  |  |  |
| Administrador/Vendedor | Consultar aplicaciones de saldo por filtro | Permite buscar, listar y filtrar las aplicaciones de saldo según los criterios de búsqueda enviados | AplicacionSaldo | Filtros de aplicaciones de saldo | Contiene los parámetros o criterios de búsqueda enviados para filtrar la consulta | P-APS-005 | Asegurar que los datos requeridos de la aplicación de saldo sean válidos en tipo de dato, obligatoriedad, longitud y formato |  | Aplicaciones de saldo encontradas |  |

### Políticas

| Número Política | Descripción Política | Objeto Responsable |
|---|---|---|
| P-APS-001 | Asegurar que el id de la aplicación de saldo sea único e irrepetible | AplicacionSaldo |
| P-APS-002 | Asegurar que un saldo favor solo se use una vez en un pago específico (se puede usar varias veces en distintos pagos) | AplicacionSaldo |
| P-APS-003 | Asegurar que el valor aplicado no sobrepase el monto pendiente para pagar la compra | AplicacionSaldo |
| P-APS-004 | Asegurar que el valor aplicado no sobrepase el monto disponible del saldo a favor asociado al cliente | AplicacionSaldo |
| P-APS-005 | Asegurar que los datos requeridos de la aplicación de saldo sean válidos en tipo de dato, obligatoriedad, longitud y formato | AplicacionSaldo |

[↑ Volver al índice](#objetos-de-dominio)
