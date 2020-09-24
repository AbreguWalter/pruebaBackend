/*Tabla MonedaDestino*/
insert into MONEDA_DESTINO(moneda,valor,simbolo) values ('dolares','3.14','$');
insert into MONEDA_DESTINO(moneda,valor,simbolo) values ('soles','1','S/');

/*Tabla Tipo de Cambio*/
insert into TIPO_DE_CAMBIO(moneda_destino,moneda_origen,monto,monto_tipo_cambio,tipo_cambio) values ('dolares','soles','100','$ 27.98','3.14');

