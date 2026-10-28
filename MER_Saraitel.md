# Modelo Entidad-Relación (MER) — Saraitel

> Documentación generada a partir del archivo `MER_Saraitel.xlsx`.

## Entidades

| # | Entidad | Descripción |
|---|---|---|
| 1 | [Pais](#pais) | Representa el país al que pertenecen las sedes. |
| 2 | [MetodoPago](#metodopago) | Representa las formas en que un cliente puede cancelar una compra (efectivo, tarjeta, transferencia, Nequi, entre otras). |
| 3 | [Cliente](#cliente) | Representa a la persona que adquiere productos en cualquiera de las sedes del negocio. |
| 4 | [Marca](#marca) | Representa al fabricante de los accesorios y repuestos que comercializa el negocio. |
| 5 | [Motivo](#motivo) | Representa la razón por la que un cliente solicita devolver un producto. |
| 6 | [TipoDocumento](#tipodocumento) | Representa el tipo de documento de identidad de una persona |
| 7 | [Categoria](#categoria) | Representa la clasificación a la que pertenece un producto dentro del catálogo. |
| 8 | [Prefijo](#prefijo) | Representa el código de marcado telefónico asociado a un país para el registro de números de contacto |
| 9 | [Persona](#persona) | Representa a un individuo en el sistema con sus datos generales de identificación para registrarse en el sistema |
| 10 | [Producto](#producto) | Representa un artículo del catálogo general del negocio, independiente de la sede en la que se encuentre. |
| 11 | [Departamento](#departamento) | Representa el departamento o división administrativa al que pertenece una ciudad dentro de un país. |
| 12 | [ClienteRegistrado](#clienteregistrado) | Representa al cliente cuyos datos de identificación y contacto han sido registrados en el sistema |
| 13 | [ClienteNoRegistrado](#clientenoregistrado) | Representa a la persona que realiza una compra sin contar con un registro previo en el sistema |
| 14 | [ClienteRegistradoN](#clienteregistradon) | Representa al cliente registrado natural en el sistema con sus datos básicos de identificación y contacto |
| 15 | [ClienteRegistradoJ](#clienteregistradoj) | Representa al cliente registrado Jurídico en el sistema con sus datos básicos de identificación y contacto |
| 16 | [Ciudad](#ciudad) | Representa la ciudad o municipio donde se ubican las sedes del negocio y residen los clientes. |
| 17 | [Sede](#sede) | Representa cada local físico del negocio, donde se atienden las compras y se almacena la mercancía. |
| 18 | [IngresoInventario](#ingresoinventario) | Representa la factura de la llegada de nueva mercancía a una sede. |
| 19 | [Empleado](#empleado) | Representa al personal contratado que trabaja en una sede específica, es quien atiende las compras de los clientes. |
| 20 | [ProductoSede](#productosede) | Representa el inventario real de un producto en una sede determinada. |
| 21 | [Administrador](#administrador) | Representa la especialización del empleado con permisos administrativos sobre la operación del negocio. |
| 22 | [Vendedor](#vendedor) | Representa la especialización del empleado encargado de atender a los clientes en la sede. |
| 23 | [ProcesoCompra](#procesocompra) | Representa el flujo que controla los estados y transiciones de una compra. |
| 24 | [DetalleIngreso](#detalleingreso) | Representa el detalle de cada producto que entró de mercancía al negocio, su cantidad, precio y demás atributos. |
| 25 | [DetalleCompra](#detallecompra) | Representa el detalle de cada producto que se vendió en una sede específica, su cantidad, precio y demás atributos. |
| 26 | [Compra](#compra) | Representa la transacción en la que un cliente adquiere uno o varios productos en una sede, es atendida por un empleado. |
| 27 | [Pago](#pago) | Representa el abono que realiza el cliente para saldar una compra. |
| 28 | [Factura](#factura) | Representa el comprobante legal de venta que se genera a partir de una compra ya pagada |
| 29 | [Devolución](#devolución) | Representa la solicitud de un cliente de devolver un producto si cumple con las condiciones establecidas en el negocio. |
| 30 | [PagoNormal](#pagonormal) | Representa la especialización del pago realizado directamente por el cliente mediante un método de pago |
| 31 | [SaldoFavor](#saldofavor) | Representa el saldo a favor del cliente generado por una devolución de mercancía. |
| 32 | [AplicacionSaldo](#aplicacionsaldo) | Representa el uso de un saldo a favor sobre un pago con saldo, y permite controlar el saldo de un cliente específico. |

---

## Pais

**Descripción:** Representa el país al que pertenecen las sedes.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del país |
| Nombre | VARCHAR | 100 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre oficial del país |

[↑ Volver al índice](#entidades)

---

## MetodoPago

**Descripción:** Representa las formas en que un cliente puede cancelar una compra (efectivo, tarjeta, transferencia, Nequi, entre otras).

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del método de pago |
| Nombre | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre del método de pago disponible en el negocio |
| EsActivo | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Indica si el método de pago está disponible para utilizarse. |

[↑ Volver al índice](#entidades)

---

## Cliente

**Descripción:** Representa a la persona que adquiere productos en cualquiera de las sedes del negocio.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del cliente |
| ClientePorDefecto | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Indica si la compra debe asociarse al cliente no registrado cuando el comprador no desea ser registrado en el sistema. |

[↑ Volver al índice](#entidades)

---

## Marca

**Descripción:** Representa al fabricante de los accesorios y repuestos que comercializa el negocio.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la marca |
| Nombre | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre del fabricante de los productos |
| EsActivo | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si una marca específica sigue siendo usada en la empresa |

[↑ Volver al índice](#entidades)

---

## Motivo

**Descripción:** Representa la razón por la que un cliente solicita devolver un producto.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del motivo |
| Nombre | VARCHAR | 40 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre del motivo de devolución |

[↑ Volver al índice](#entidades)

---

## TipoDocumento

**Descripción:** Representa el tipo de documento de identidad de una persona

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del tipo de documento |
| Tipo | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el nombre del tipo de documento de identidad de una persona |

[↑ Volver al índice](#entidades)

---

## Categoria

**Descripción:** Representa la clasificación a la que pertenece un producto dentro del catálogo.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la categoría |
| Nombre | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre de la clasificación de productos |
| CategoriaPadre | VARCHAR | 50 |  |  | NO | NO | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Identifica la categoría principal o superior a la que pertenece la clasificación correspondiente |
| Nivel | INT |  | 2 |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Indica el nivel de profundidad jerárquica de la categoría dentro de la estructura del catálogo |

[↑ Volver al índice](#entidades)

---

## Prefijo

**Descripción:** Representa el código de marcado telefónico asociado a un país para el registro de números de contacto

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del Prefijo |
| Codigo | VARCHAR | 8 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el código indicativo internacional de marcado telefónico |

[↑ Volver al índice](#entidades)

---

## Persona

**Descripción:** Representa a un individuo en el sistema con sus datos generales de identificación para registrarse en el sistema

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la persona |
| TipoDocumento | UUID |  |  |  | NO | SI | NO | SI | TipoDocumento | Tipo | NO |  | NO |  | NO |  |  |  | Representa el tipo de documento de identidad de la persona |
| Prefijo | UUID |  |  |  | NO | SI | NO | SI | Prefijo | Codigo | NO |  | NO |  | NO |  |  |  | Representa el código indicativo internacional de marcado telefónico asociado al teléfono de la persona |
| NumeroDocumento | VARCHAR | 20 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el número del documento de identidad de la persona |
| Teléfono | VARCHAR | 15 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Número de contacto de la persona |
| Nombre | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el nombre de la persona |
| Apellido | VARCHAR | 100 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el apellido de la persona |
| Correo | VARCHAR | 254 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Correo electrónico de las personas |
| TelefonoConfirmado | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si el teléfono de la persona está confirmado o no |
| CorreoConfirmado | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si el correo electrónico de la persona está confirmado o no |

[↑ Volver al índice](#entidades)

---

## Producto

**Descripción:** Representa un artículo del catálogo general del negocio, independiente de la sede en la que se encuentre.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del producto |
| Marca | UUID |  |  |  | NO | SI | NO | SI | Marca | Nombre | NO |  | NO |  | NO |  |  |  | Marca a la que pertenece el producto |
| Categoria | UUID |  |  |  | NO | SI | NO | SI | Categoria | Nombre | NO |  | NO |  | NO |  |  |  | Categoría a la que pertenece el producto |
| Modelo | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Modelo o referencia única del producto |
| Nombre | VARCHAR | 60 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre del accesorio dentro del catálogo general |
| Descripcion | VARCHAR | 500 |  |  | NO | NO | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Descripción general del accesorio |

[↑ Volver al índice](#entidades)

---

## Departamento

**Descripción:** Representa el departamento o división administrativa al que pertenece una ciudad dentro de un país.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del departamento |
| Pais | UUID |  |  |  | NO | SI | NO | SI | Pais | Nombre | NO |  | NO |  | NO |  |  |  | País al que pertenece el departamento |
| Nombre | VARCHAR | 100 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre oficial del departamento o división administrativa |

[↑ Volver al índice](#entidades)

---

## ClienteRegistrado

**Descripción:** Representa al cliente cuyos datos de identificación y contacto han sido registrados en el sistema

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del cliente registrado |
| Cliente | UUID |  |  |  | NO | SI | NO | SI | Cliente | ID | NO |  | NO |  | NO |  |  |  | Referencia al cliente asociado al cliente registrado |

[↑ Volver al índice](#entidades)

---

## ClienteNoRegistrado

**Descripción:** Representa a la persona que realiza una compra sin contar con un registro previo en el sistema

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del cliente no registrado |
| Cliente | UUID |  |  |  | NO | SI | NO | SI | Cliente | ID | NO |  | NO |  | NO |  |  |  | Cliente base al que corresponde el cliente no registrado |

[↑ Volver al índice](#entidades)

---

## ClienteRegistradoN

**Descripción:** Representa al cliente registrado natural en el sistema con sus datos básicos de identificación y contacto

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del cliente registrado natural |
| ClienteRegistrado | UUID |  |  |  | NO | SI | NO | SI | ClienteRegistrado | ID | NO |  | NO |  | NO |  |  |  | Referencia al cliente registrado asociado al cliente registrado natural |
| Persona | UUID |  |  |  | NO | SI | NO | SI | Persona | ID | NO |  | NO |  | NO |  |  |  | Referencia a la persona asociada al cliente registrado natural |

[↑ Volver al índice](#entidades)

---

## ClienteRegistradoJ

**Descripción:** Representa al cliente registrado Jurídico en el sistema con sus datos básicos de identificación y contacto

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del cliente registrado jurídico |
| ClienteRegistrado | UUID |  |  |  | NO | SI | NO | SI | ClienteRegistrado | ID | NO |  | NO |  | NO |  |  |  | Representa al cliente registrado asociado al cliente registrado jurídico |
| Prefijo | UUID |  |  |  | NO | SI | NO | SI | Prefijo | ID | NO |  | NO |  | NO |  |  |  | Representa el código indicativo internacional de marcado telefónico del cliente registrado jurídico |
| Telefono | VARCHAR | 15 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Número de contacto de un cliente registrado jurídico |
| Nit | VARCHAR | 20 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el número del documento de un cliente registrado jurídico |
| RazonSocial | VARCHAR | 50 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Representa el nombre de un cliente registrado jurídico |
| Correo | VARCHAR | 254 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Correo electrónico de un cliente registrado jurídico |
| CorreoConfirmado | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si el correo de un cliente registrado jurídico está confirmado o no |
| TelefonoConfirmado | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si el teléfono de un cliente registrado jurídico está confirmado o no |

[↑ Volver al índice](#entidades)

---

## Ciudad

**Descripción:** Representa la ciudad o municipio donde se ubican las sedes del negocio y residen los clientes.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la ciudad |
| Departamento | UUID |  |  |  | NO | SI | NO | SI | Departamento | Nombre | NO |  | NO |  | NO |  |  |  | Departamento al que pertenece la ciudad |
| Nombre | VARCHAR | 100 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre oficial de la ciudad o municipio |

[↑ Volver al índice](#entidades)

---

## Sede

**Descripción:** Representa cada local físico del negocio, donde se atienden las compras y se almacena la mercancía.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la sede |
| Ciudad | UUID |  |  |  | NO | SI | NO | SI | Ciudad | Nombre | NO |  | NO |  | NO |  |  |  | Ciudad en la que está ubicada la sede |
| Nombre | VARCHAR | 100 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Nombre con el que se identifica el local físico |
| Nit | VARCHAR | 20 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Número de NIT legal con el que se identifica la sede |
| Direccion | VARCHAR | 200 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Dirección física donde está ubicada la sede |
| EsActiva | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si una sede está funcionando actualmente o no |

[↑ Volver al índice](#entidades)

---

## IngresoInventario

**Descripción:** Representa la factura de la llegada de nueva mercancía a una sede.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del ingreso de inventario |
| Estado | VARCHAR | 20 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Estado actual del ingreso de inventario (En proceso, Cancelado y Creado) |
| Sede | UUID |  |  |  | NO | SI | NO | SI | Sede | Nombre | NO |  | NO |  | NO |  |  |  | Nombre de la sede que recibe la mercancía |
| FechaLlegada | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha en que llega la mercancía a la sede |
| Total | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Valor total de la mercancía ingresada |

[↑ Volver al índice](#entidades)

---

## Empleado

**Descripción:** Representa al personal contratado que trabaja en una sede específica, es quien atiende las compras de los clientes.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del empleado |
| Sede | UUID |  |  |  | NO | SI | NO | SI | Sede | Nombre | NO |  | NO |  | NO |  |  |  | Referencia a la sede en la que trabaja el empleado |
| Persona | UUID |  |  |  | NO | SI | NO | SI | Persona | Nombre | NO |  | NO |  | NO |  |  |  | Referencia a la persona asociada al empleado |
| EsActivo | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Indica si el empleado se encuentra activo en el negocio |

[↑ Volver al índice](#entidades)

---

## ProductoSede

**Descripción:** Representa el inventario real de un producto en una sede determinada.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del inventario físico producto-sede |
| Producto | UUID |  |  |  | NO | SI | NO | SI | Producto | Modelo | NO |  | NO |  | NO |  |  |  | Producto del catálogo general de la empresa |
| IdSede | UUID |  |  |  | NO | SI | NO | SI | Sede | Nombre | NO |  | NO |  | NO |  |  |  | Nombre de la sede donde se encuentra el inventario |
| Precio | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Precio de venta local del producto en la sede |
| TieneOferta | BOOLEAN |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Variable booleana que define si un producto específico en una sede tiene oferta actualmente o no |
| Oferta | INT |  | 3 |  | NO | NO | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Oferta que se le aplica al producto correspondiente, definida por el administrador |
| PrecioTrasOferta | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Valor calculado al aplicar el descuento correspondiente al precio del producto en cuestión |
| Stock | INT |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Cantidad de unidades disponibles del producto en la sede |
| StockGarantia | INT |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Cantidad de unidades que necesitan cambio del producto específico en la sede |

[↑ Volver al índice](#entidades)

---

## Administrador

**Descripción:** Representa la especialización del empleado con permisos administrativos sobre la operación del negocio.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del administrador |
| Empleado | UUID |  |  |  | NO | SI | NO | SI | Empleado | ID | NO |  | NO |  | NO |  |  |  | Referencia al empleado que desempeña el rol de administrador |

[↑ Volver al índice](#entidades)

---

## Vendedor

**Descripción:** Representa la especialización del empleado encargado de atender a los clientes en la sede.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del vendedor |
| Empleado | UUID |  |  |  | NO | SI | NO | SI | Empleado | ID | NO |  | NO |  | NO |  |  |  | Referencia al empleado que desempeña el rol de vendedor |

[↑ Volver al índice](#entidades)

---

## ProcesoCompra

**Descripción:** Representa el flujo que controla los estados y transiciones de una compra.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del proceso de compra |
| Cliente | UUID |  |  |  | NO | SI | NO | SI | Cliente | ID | NO |  | NO |  | NO |  |  |  | Cliente asociado al proceso de compra |
| Empleado | UUID |  |  |  | NO | SI | NO | SI | Empleado | ID | NO |  | NO |  | NO |  |  |  | Empleado responsable del proceso de compra |
| FechaInicio | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha de inicio del proceso de la compra |
| FechaActualizacion | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha de última actualización del proceso de la compra |
| TotalCompra | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Valor total de la compra, se confirma el cálculo cuando el estado es Creado |
| Estado | VARCHAR | 12 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Estado actual del proceso (En proceso, Anulado y Creado) |

[↑ Volver al índice](#entidades)

---

## DetalleIngreso

**Descripción:** Representa el detalle de cada producto que entró de mercancía al negocio, su cantidad, precio y demás atributos.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de cada detalle del ingreso |
| IngresoInventario | UUID |  |  |  | NO | SI | NO | SI | IngresoInventario | ID | NO |  | NO |  | NO |  |  |  | Factura de ingreso de inventario al que pertenece cada detalle de producto correspondiente |
| ProductoSede | UUID |  |  |  | NO | SI | NO | SI | ProductoSede | Modelo+Nombre | NO |  | NO |  | NO |  |  |  | Hace referencia al producto-sede que ingresa en la factura correspondiente |
| Cantidad | INT |  | 5 |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Cantidad de unidades que ingresan de ese producto |
| CostoUnitario | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Costo de compra por unidad al proveedor |
| Subtotal | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Resultado de cantidad por el costo unitario del producto |

[↑ Volver al índice](#entidades)

---

## DetalleCompra

**Descripción:** Representa el detalle de cada producto que se vendió en una sede específica, su cantidad, precio y demás atributos.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la línea de detalle de la compra |
| ProcesoCompra | UUID |  |  |  | NO | SI | NO | SI | ProcesoCompra | ID | NO |  | NO |  | NO |  |  |  | Identificación del proceso de compra al que pertenece el detalle de compra del producto correspondiente |
| ProductoSede | UUID |  |  |  | NO | SI | NO | SI | ProductoSede | Modelo+Sede | NO |  | NO |  | NO |  |  |  | Hace referencia al producto en su sede correspondiente en la que se realizó la venta |
| Cantidad | INT |  | 5 |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Cantidad de unidades vendidas de ese producto |
| PrecioUnitario | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Precio de venta por unidad en el momento de la compra; queda permanente en el tiempo aunque cambie el precio del producto |
| Subtotal | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Resultado de cantidad por el precio unitario del producto |

[↑ Volver al índice](#entidades)

---

## Compra

**Descripción:** Representa la transacción en la que un cliente adquiere uno o varios productos en una sede, es atendida por un empleado.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la compra |
| ProcesoCompra | UUID |  |  |  | NO | SI | NO | SI | ProcesoCompra | ID | NO |  | NO |  | NO |  |  |  | Proceso de compra asociado a la compra |
| FechaCompra | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha en que se realiza la compra |
| Estado | VARCHAR | 12 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Estado actual de la compra (Pendiente, Pagado y Anulado) |

[↑ Volver al índice](#entidades)

---

## Pago

**Descripción:** Representa el abono que realiza el cliente para saldar una compra.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del pago |
| Compra | UUID |  |  |  | NO | SI | NO | SI | Compra | ID | NO |  | NO |  | NO |  |  |  | Identificación de la compra que se está saldando |
| MontoPendiente | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Valor abonado por el cliente en este pago |
| FechaPago | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha en que se realiza el abono |

[↑ Volver al índice](#entidades)

---

## Factura

**Descripción:** Representa el comprobante legal de venta que se genera a partir de una compra ya pagada

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la factura |
| Compra | UUID |  |  |  | NO | SI | NO | SI | Compra | ID | NO |  | NO |  | NO |  |  |  | Identificación de la compra con la que se hace la factura |
| FechaEmision | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha en que se emite la factura |

[↑ Volver al índice](#entidades)

---

## Devolución

**Descripción:** Representa la solicitud de un cliente de devolver un producto si cumple con las condiciones establecidas en el negocio.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la devolución |
| DetalleCompra | UUID |  |  |  | NO | SI | NO | SI | DetalleCompra | ID+Modelo+Nombre | NO |  | NO |  | NO |  |  |  | Producto comprado que el cliente desea devolver |
| Motivo | UUID |  |  |  | NO | SI | NO | SI | Motivo | Nombre | NO |  | NO |  | NO |  |  |  | Motivo o razón por la cual el cliente devuelve el producto |
| FechaDevolucion | TIMESTAMP |  |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Fecha en que el cliente solicita la devolución |
| Cantidad | INT |  | 5 |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Cantidad de productos que el cliente desea devolver |
| MontoDevolucion | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Monto de la devolución calculado con la cantidad del producto y su precio unitario en el detalleCompra |
| Estado | VARCHAR | 9 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Estado actual de la solicitud de devolución (Pendiente, Aprobada, Rechazada) |

[↑ Volver al índice](#entidades)

---

## PagoNormal

**Descripción:** Representa la especialización del pago realizado directamente por el cliente mediante un método de pago

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del pago normal |
| MetodoPago | UUID |  |  |  | NO | SI | NO | SI | MetodoPago | Nombre | NO |  | NO |  | NO |  |  |  | Método de pago utilizado para realizar el pago normal |
| Pago | UUID |  |  |  | NO | SI | NO | SI | Pago | ID | NO |  | NO |  | NO |  |  |  | Pago base asociado a la transacción realizada |
| MontoPagar | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Indica la cantidad de dinero que se va a pagar en esta transacción |

[↑ Volver al índice](#entidades)

---

## SaldoFavor

**Descripción:** Representa el saldo a favor del cliente generado por una devolución de mercancía.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único del saldo a favor |
| Devolucion | UUID |  |  |  | NO | SI | NO | SI | Devolución | ID | NO |  | NO |  | NO |  |  |  | Referencia a la devolución que generó el saldo a favor |
| MontoDisponible | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Monto del saldo a favor que aún queda disponible para que el cliente lo use en nuevos pagos |
| Estado | VARCHAR | 10 |  |  | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Estado actual del saldo (Disponible, Aplicado y Anulado) |

[↑ Volver al índice](#entidades)

---

## AplicacionSaldo

**Descripción:** Representa el uso de un saldo a favor sobre un pago con saldo, y permite controlar el saldo de un cliente específico.

#### Atributos

| Nombre | Tipo de dato | Longitud | Cantidad dígitos parte entera | Cantidad dígitos parte decimal (Precisión) | ¿Es autoincremento? | ¿Es obligatorio? | ¿Es llave primaria o es parte de ella? | Llave Foránea / ¿Es llave foránea? | Llave Foránea / Entidad | Llave Foránea / Columna(s) | Restricciones de unicidad / ¿Posee restricción de unicidad o es parte de ella? | Restricciones de unicidad / Nombre restricción unicidad a la que pertenece | Restricciones de chequeo / ¿Posee restricción de chequeo o es parte de ella? | Restricciones de chequeo / Nombre restricción chequeo a la que pertenece | Restricciones de índice / ¿Posee restricción de índice o es parte de ella? | Restricciones de índice / Tipo | Restricciones de índice / Nombre restricción índice a la que pertenece | Alias | Descripción del campo |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| ID | UUID |  |  |  | NO | SI | SI | NO |  |  | NO |  | NO |  | NO |  |  |  | Identificador único de la aplicación de saldo |
| SaldoFavor | UUID |  |  |  | NO | SI | NO | SI | SaldoFavor | ID | NO |  | NO |  | NO |  |  |  | Referencia al saldo a favor del cliente del cual se toma el monto que se aplica |
| Pago | UUID |  |  |  | NO | SI | NO | SI | Pago | ID | NO |  | NO |  | NO |  |  |  | Referencia al pago sobre el cual se aplica el saldo a favor |
| ValorAplicado | DECIMAL |  | 12 | 2 | NO | SI | NO | NO |  |  | NO |  | NO |  | NO |  |  |  | Monto del saldo a favor que se aplica en este pago |

[↑ Volver al índice](#entidades)
