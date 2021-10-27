Drop Database If Exists TransportesBD;

Create Database TransportesBD;
Use TransportesBD;

CREATE TABLE IF NOT EXISTS tb_ciudad (
    codCiudad CHAR(5) NOT NULL,
    nomCiudad VARCHAR(20) NOT NULL,
    PRIMARY KEY (codCiudad)
);

Insert Into tb_ciudad Values ('CI001', 'Abancay');
Insert Into tb_ciudad Values ('CI002', 'Arequipa');
Insert Into tb_ciudad Values ('CI003', 'Chiclayo');
Insert Into tb_ciudad Values ('CI004', 'Chimbote');
Insert Into tb_ciudad Values ('CI005', 'Cusco');
Insert Into tb_ciudad Values ('CI006', 'Huancayo');
Insert Into tb_ciudad Values ('CI007', 'Huaraz');
Insert Into tb_ciudad Values ('CI008', 'Ica');
Insert Into tb_ciudad Values ('CI009', 'Lima');
Insert Into tb_ciudad Values ('CI010', 'Mancora');
Insert Into tb_ciudad Values ('CI011', 'Moquegua');
Insert Into tb_ciudad Values ('CI012', 'Nazca');
Insert Into tb_ciudad Values ('CI013', 'Piura');
Insert Into tb_ciudad Values ('CI014', 'Tacna');
Insert Into tb_ciudad Values ('CI015', 'Trujillo');

CREATE TABLE IF NOT EXISTS tb_tipoDocumento (
    idTipoDocumento INT NOT NULL ,
    nombreTipoDocumento VARCHAR(45) NULL,
    PRIMARY KEY (idTipoDocumento)
)  ENGINE=InnoDB;
insert into tb_tipoDocumento values (1,'DNI');
insert into tb_tipoDocumento values (2,'RUC');
insert into tb_tipoDocumento values (3,'PASAPORTE');
insert into tb_tipoDocumento values (4,'CARNE EXTRANJERIA');

CREATE TABLE IF NOT EXISTS tb_admin (
    codAdmin CHAR(5) NOT NULL DEFAULT '',
    usuario VARCHAR(10) NOT NULL,
    clave VARCHAR(8) NOT NULL,
    nomAdmin VARCHAR(20) NOT NULL,
    apePaterAdmin VARCHAR(20) NOT NULL,
    apeMaterAdmin VARCHAR(20) NOT NULL DEFAULT 'X',
    TipoDocumento INT NOT NULL,
    nroDocumentoId VARCHAR(11) NOT NULL,
    sexo CHAR(1) NULL DEFAULT NULL,
    fechaNac DATE NOT NULL,
    email VARCHAR(25) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    codCiudad CHAR(5) NOT NULL,
    foto LONGBLOB NULL DEFAULT NULL,
    estado INT NULL DEFAULT NULL,
    PRIMARY KEY (codAdmin),
    CONSTRAINT tb_admin_ibfk_1 FOREIGN KEY (codCiudad)
        REFERENCES tb_ciudad (codCiudad)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_tb_admin_1 FOREIGN KEY (TipoDocumento)
        REFERENCES tb_tipoDocumento (idTipoDocumento)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;

Insert Into tb_admin Values('AD001', 'APANTIGOSO', '1234', 'Alvaro', 'Pantigoso', 'Garcia', 1, '12968429', 'M', '1990/01/01', 'apanti@hotmail.com', '6660000','CI002',null,0);
Insert Into tb_admin Values('AD002', 'MVELA', '1234', 'Marco', 'Vela', 'Villamonte', 1, '13479865', 'M', '1989/01/03', 'mvela@hotmail.com', '6662222','CI002',null,0);
Insert Into tb_admin Values('AD003', 'OURIOL', '1234', 'Omar', 'Uriol', 'Gutierrez', 1, '71004838', 'M', '1990/02/05', 'ouriol@gmail.com', '8798988','CI002',null,0);
Insert Into tb_admin Values('AD004', 'KPILLACA', '1234', 'Kevin', 'Pillaca', 'Choquehuanca', 1, '08994670', 'M', '1990/10/12', 'kevin@gmail.com', '3242352','CI003',null,0);
Insert Into tb_admin Values('AD005', 'RTUTUMI', '1234', 'Raquel', 'Tutumi', 'Lavado', 1, '41872742', 'F', '1990/07/11', 'rtutumi@gmail.com', '3439408','CI005',null,0);

CREATE TABLE IF NOT EXISTS tb_chofer (
    codChofer CHAR(5) NOT NULL,
    nroLicencia CHAR(9) NOT NULL,
    nomChofer VARCHAR(20) NOT NULL,
    apePaterChofer VARCHAR(20) NOT NULL,
    apeMaterChofer VARCHAR(20) NOT NULL DEFAULT 'X',
    TipoDocumento INT NOT NULL,
    nroDocumentoId VARCHAR(11) NOT NULL,
    sexo CHAR(1) NULL DEFAULT NULL,
    fechaNac DATE NOT NULL,
    email VARCHAR(25) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    codCiudad CHAR(5) NOT NULL,
    foto LONGBLOB NULL DEFAULT NULL,
    estado INT NULL DEFAULT NULL,
    PRIMARY KEY (codChofer),
    UNIQUE INDEX nroLicencia (nroLicencia ASC),
    UNIQUE INDEX nroDocumentoId (nroDocumentoId ASC),
    INDEX codCiudad (codCiudad ASC),
    INDEX fk_tb_chofer_1_idx (TipoDocumento ASC),
    CONSTRAINT tb_chofer_ibfk_1 FOREIGN KEY (codCiudad)
        REFERENCES tb_ciudad (codCiudad)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_tb_chofer_1 FOREIGN KEY (TipoDocumento)
        REFERENCES tb_tipoDocumento (idTipoDocumento)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;

insert into tb_chofer values('CH001',  '07874624', 'Renato', 'Perez', 'Vega', 1, '11548704', 'M', '1990/01/09', 'rperez@hotmail.com', '6668888','CI009',null,0);
insert into tb_chofer values('CH002',  '09895673', 'David', 'Osorio', 'Mendo', 1, '09091837', 'M', '1990/01/10', 'dosori@hotmail.com', '6669999','CI001',null,0);
insert into tb_chofer values('CH003',  '02837182', 'Jose', 'Solis', 'Iturraran', 1, '12442543', 'M', '1990/01/11', 'jsolis@hotmail.com', '6565123', 'CI001',null,0);
insert into tb_chofer values('CH004',  '01829371', 'David', 'Mercado', 'Vargas', 1, '234524531', 'M', '1990/01/12', 'dmerca@hotmail.com', '6565321', 'CI002',null,0);
insert into tb_chofer values('CH005',  '03748273', 'Rene', 'Salas', 'Aguilar', 1, '12356734', 'M', '1990/01/13', 'rsalas@hotmail.com', '6565787', 'CI001',null,0);
insert into tb_chofer values('CH006',  '07438274', 'Carlos', 'Tapia', 'Fuentes', 1, '13245765', 'M', '1990/01/14', 'ctapia@hotmail.com', '6565878', 'CI002',null,0);
insert into tb_chofer values('CH007',  '01837648', 'Pedro', 'Fano', 'Magallanes', 1, '15245445', 'M', '1990/01/15', '@hotmail.com', '6565453', 'CI002',null,0);
insert into tb_chofer values('CH008',  '03847929', 'Paul', 'Abad', 'Rojas', 1, '16234523', 'M', '1990/01/16', 'pabad@hotmail.com', '6565354', 'CI003',null,0);
insert into tb_chofer values('CH009',  '01827482', 'Gabriel', 'Castillo', 'Saulo', 1, '19244523', 'M', '1990/01/17', 'gcasti@hotmail.com', '8989342', 'CI005',null,0);
insert into tb_chofer values('CH010', '02842891', 'Isaac', 'Arnaldo', 'Alvarez', 1, '21354264', 'M', '1990/01/18', 'iarnal@hotmail.com', '8989243', 'CI006',null,0);
insert into tb_chofer values('CH011', '01243423', 'Dalton', 'Curich', 'Velazques', 1, '13298427', 'M', '1990/01/19', 'dcuric@hotmail.com', '6666123', 'CI002',null,0);
insert into tb_chofer values('CH012', '01893748', 'Manuel', 'Cartagena', 'Vera', 1, '32891209', 'M', '1990/01/20', 'mcarta@hotmail.com', '6666126', 'CI003',null,0);
insert into tb_chofer values('CH013', '02849572', 'Juan', 'Delgado', 'Montoya', 1, '19230582', 'M', '1990/01/21', 'jdelga@hotmail.com', '6666234', 'CI001',null,0);
insert into tb_chofer values('CH014', '02847583', 'Edison', 'Laulate', 'Aso', 1, '45820485', 'M', '1990/01/22', 'elaula@hotmail.com', '6666345', 'CI004',null,0);
insert into tb_chofer values('CH015', '03817382', 'Sergio', 'Soto', 'Hayashi', 1, '12940138', 'M', '1990/01/23', 'ssoto@hotmail.com', '6666456', 'CI003',null,0);
insert into tb_chofer values('CH016', '09457842', 'Marco', 'Garcia', 'Zambrano', 1, '19849578', 'M', '1990/01/24', 'mgarci@hotmail.com', '6666567', 'CI002',null,0);
insert into tb_chofer values('CH017', '09172319', 'John', 'CazaFranca', 'Cerna', 1, '19849512', 'M', '1990/01/12', 'jccerna@hotmail.com', '6661267', 'CI003',null,0);
insert into tb_chofer values('CH018', '01938293', 'Jesus', 'Zamora', 'Chirinos', 1, '32894091', 'M', '1990/01/26', 'jzamor@hotmail.com', '6666432', 'CI005',null,0);
insert into tb_chofer values('CH019', '01827843', 'Kevin', 'Zevallos', 'Guerrero', 1, '42891209', 'M', '1990/01/27', 'kzeval@hotmail.com', '6666543', 'CI006',null,0);
insert into tb_chofer values('CH020', '03895893', 'Kei', 'Alarcon', 'Talledo', 1, '32891239', 'M', '1990/01/28', 'kalarc@hotmail.com', '6666765', 'CI009',null,0);
insert into tb_chofer values('CH021', '05984982', 'Joshua', 'Suazo', 'Reategui', 1, '13892302', 'M', '1990/01/29', 'jsuazo@hotmail.com', '6666009', 'CI010',null,0);
insert into tb_chofer values('CH022', '02395847', 'Miguel', 'Del Aguila', 'Pascual', 1, '12983209', 'M', '1990/01/30', 'mdelag@hotmail.com', '6666877', 'CI009',null,0);
insert into tb_chofer values('CH023', '03289424', 'Martin', 'Del Solar', 'Amado', 1, '32892019', 'M', '1990/01/31', 'mdelso@hotmail.com', '6666532', 'CI010',null,0);
insert into tb_chofer values('CH024', '01394834', 'Dante', 'De la Cruz', 'Pasco', 1, '43891209', 'M', '1990/01/01', 'ddelac@hotmail.com', '6666879', 'CI009',null,0);
insert into tb_chofer values('CH025', '01948934', 'Edson', 'Velacruz', 'Nitales', 1, '12032989', 'M', '1990/01/02', 'evelac@hotmail.com', '6666423', 'CI009',null,0);
insert into tb_chofer values('CH026', '01278542', 'Jorge', 'Muentes', 'Nostades', 1, '12892039', 'M', '1990/01/03', 'jmuentes@hotmail.com', '6666502', 'CI008',null,0);
insert into tb_chofer values('CH027', '01287847', 'Jordan', 'Martinez', 'Castaneda', 1, '12915909', 'M', '1990/01/04', 'jmarti@hotmail.com', '6666279', 'CI008',null,0);
insert into tb_chofer values('CH028', '05968394', 'Segundo', 'Anto', 'Partamo', 1, '21984929', 'M', '1990/01/05', 'santo@hotmail.com', '6666368', 'CI009',null,0);
insert into tb_chofer values('CH029', '01287854', 'Justo', 'Cabrejo', 'Zarate', 1, '21983292', 'M', '1990/01/06', 'jcabre@hotmail.com', '6666238', 'CI009',null,0);
insert into tb_chofer values('CH030', '03489578', 'Ernesto', 'Cantares', 'Camacho', 1, '31983289', 'M', '1990/01/07', 'ecanta@hotmail.com', '6666135', 'CI010',null,0);

CREATE TABLE IF NOT EXISTS tb_terramoza (
    codTerramoza CHAR(5) NOT NULL,
    nomTerramoza VARCHAR(20) NOT NULL,
    apePaterTerramoza VARCHAR(20) NOT NULL,
    apeMaterTerramoza VARCHAR(20) NOT NULL DEFAULT 'X',
    TipoDocumento INT NOT NULL,
    nroDocumentoId VARCHAR(11) NOT NULL,
    sexo CHAR(1) NULL DEFAULT NULL,
    fechaNac DATE NOT NULL,
    email VARCHAR(25) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    codCiudad CHAR(5) NOT NULL,
    foto LONGBLOB NULL DEFAULT NULL,
    estado INT NULL DEFAULT NULL,
    PRIMARY KEY (codTerramoza),
    CONSTRAINT tb_terramoza_ibfk_1 FOREIGN KEY (codCiudad)
        REFERENCES tb_ciudad (codCiudad)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_tb_terramoza_1 FOREIGN KEY (TipoDocumento)
        REFERENCES tb_tipoDocumento (idTipoDocumento)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;

insert into tb_terramoza values('TE001', 'Melody', 'Correa', 'Briolo', 1, '12437623', 'F', '1990/02/01', 'mcorre@hotmail.com', '6667575','CI007',null,0);
insert into tb_terramoza values('TE002', 'Jessica', 'Cuadros', 'Garcia', 1, '12437523', 'F', '1990/02/02', 'jcuadr@hotmail.com', '6668585','CI010',null,0);
insert into tb_terramoza values('TE003', 'Tatiana', 'Herrera', 'Ramos', 1, '1244356', 'F', '1990/02/03', 'therre@hotmail.com', '7777123', 'CI002',null,0);
insert into tb_terramoza values('TE004', 'Maya', 'Escobar', 'Ortega', 1, '1246423', 'F', '1990/02/04', 'mescob@hotmail.com', '7777124', 'CI003',null,0);
insert into tb_terramoza values('TE005', 'Kelly', 'Cori', 'Montoya', 1, '1246512', 'F', '1990/02/05', 'kcori@hotmail.com', '7777125', 'CI004',null,0);
insert into tb_terramoza values('TE006', 'Samantha', 'Mendo', 'Becerras', 1, '1242364', 'F', '1990/02/06', 'smendo@hotmail.com', '7777126', 'CI005',null,0);
insert into tb_terramoza values('TE007', 'Jazmin', 'Ruiz', 'Puertas', 1, '1244276', 'F', '1990/02/07', 'jruiz@hotmail.com', '7777127', 'CI006',null,0);
insert into tb_terramoza values('TE008', 'Bertha', 'Carpio', 'Aliaga', 1, '1245436', 'F', '1990/02/08', 'bcarpi@hotmail.com', '7777128', 'CI007',null,1);
insert into tb_terramoza values('TE009', 'Stephanie', 'Brito', 'Mendoza', 1, '1244264', 'F', '1990/02/09', 'sbrito@hotmail.com', '7777129', 'CI008',null,0);
insert into tb_terramoza values('TE010', 'Lilia', 'Reyes', 'Galarza', 1, '1245313', 'F', '1990/02/10', 'lreyes@hotmail.com', '7777130', 'CI009',null,0);
insert into tb_terramoza values('TE011', 'Erika', 'Salcedo', 'Gallegos', 1, '1245443', 'F', '1990/02/11', 'esalce@hotmail.com', '7777131', 'CI010',null,0);
insert into tb_terramoza values('TE012', 'Diana', 'Fernandez', 'Monteza', 1, '1245435', 'F', '1990/02/12', 'dferna@hotmail.com', '7777132', 'CI010',null,0);
insert into tb_terramoza values('TE013', 'Lucero', 'Pachas', 'Cueva', 1, '1243029', 'F', '1990/02/13', 'lpacha@hotmail.com', '7777133', 'CI009',null,0);
insert into tb_terramoza values('TE014', 'Carmen', 'Lopez', 'Arce', 1, '1241627', 'F', '1990/02/14', 'clopez@hotmail.com', '7777134', 'CI009',null,0);
insert into tb_terramoza values('TE015', 'Karen', 'Olivera', 'Diaz', 1, '1244893', 'F', '1990/02/15', 'kolive@hotmail.com', '7777135', 'CI002',null,0);
insert into tb_terramoza values('TE016', 'Mirkala', 'Medrano', 'Ocampo', 1, '1244378', 'F', '1990/02/16', 'mmedra@hotmail.com', '7777136', 'CI002',null,0);
insert into tb_terramoza values('TE017', 'Maria', 'Sanchez', 'Mayor', 1, '1249284', 'F', '1990/02/17', 'msanch@hotmail.com', '7777137', 'CI009',null,0);
insert into tb_terramoza values('TE018', 'Juana', 'Casas', 'Caceres', 1, '1241958', 'F', '1990/02/18', 'jcasas@hotmail.com', '7777138', 'CI010',null,0);
insert into tb_terramoza values('TE019', 'Soledad', 'Acevedo', 'Farias', 1, '1241930', 'F', '1990/02/19', 'saceve@hotmail.com', '7777139', 'CI009',null,0);
insert into tb_terramoza values('TE020', 'Katherine', 'Flores', 'Arica', 1, '1240987', 'F', '1990/02/20', 'kflore@hotmail.com', '7777140', 'CI004',null,0);
insert into tb_terramoza values('TE021', 'Claudia', 'Berrio', 'Alarcon', 1, '1249876', 'F', '1990/02/21', 'cberri@hotmail.com', '7777141', 'CI009',null,0);
insert into tb_terramoza values('TE022', 'Jacky', 'Betancur', 'Tejada', 1, '1247654', 'F', '1990/02/22', 'jbetan@hotmail.com', '7777142', 'CI010',null,0);
insert into tb_terramoza values('TE023', 'Alejandra', 'Mari', 'Mayo', 1, '1244321', 'F', '1990/02/23', 'amari@hotmail.com', '7777143', 'CI010',null,0);
insert into tb_terramoza values('TE024', 'Alexandra', 'Valle', '', 1, '1241234', 'F', '1990/02/24', 'avalle@hotmail.com', '7777144', 'CI008',null,0);
insert into tb_terramoza values('TE025', 'Alexis', 'Rua', 'Huapaya', 1, '1242345', 'F', '1990/02/25', 'arua@hotmail.com', '7777145', 'CI003',null,0);
insert into tb_terramoza values('TE026', 'Noemi', 'Neira', 'Ojeda', 1, '1243456', 'F', '1990/02/26', 'nneir@hotmail.com', '7777146', 'CI001',null,0);
insert into tb_terramoza values('TE027', 'Nicole', 'Acosta', 'Rosales', 1, '1244567', 'F', '1990/02/27', 'nacost@hotmail.com', '7777147', 'CI001',null,0);
insert into tb_terramoza values('TE028', 'Wendy', 'Daza', 'Gil', 1, '1246789', 'F', '1990/02/28', 'wdaza@hotmail.com', '7777148', 'CI007',null,0);
insert into tb_terramoza values('TE029', 'Devora', 'Osorio', 'Sifuentes', 1, '1247853', 'F', '1990/03/01', 'dosor@hotmail.com', '7777149', 'CI005',null,0);
insert into tb_terramoza values('TE030', 'Valentina', 'Sevilla', 'Moreno', 1, '1249996', 'F', '1990/03/02', 'vsevil@hotmail.com', '7777150', 'CI006',null,0);

CREATE TABLE IF NOT EXISTS tb_tipoServicio (
    idTipoServicio CHAR(1) NOT NULL,
    nombreTipoServicio VARCHAR(45) NOT NULL,
    tarifaBase DECIMAL(10 , 0 ) NULL,
    descripcion varchar(600),
    PRIMARY KEY (idTipoServicio),
    UNIQUE INDEX nombreTipoServicio_UNIQUE (nombreTipoServicio ASC)
)  ENGINE=InnoDB;

Insert Into tb_tipoServicio (idTipoServicio,nombreTipoServicio,tarifaBase) Values('N','NORMAL',10.0);
Insert Into tb_tipoServicio (idTipoServicio,nombreTipoServicio,tarifaBase) Values('V','VIP',20.0);
Insert Into tb_tipoServicio (idTipoServicio,nombreTipoServicio,tarifaBase) Values('P','PREMIER',30.0);

Update tb_tipoServicio set descripcion=
('Nuestro servicio Normal ofrece los mejores servicios en ambos pisos:
- Cabina de pilotos sin conexion con la cabina de pasajeros, para seguridad durante el viaje.
- Servicios higienicos con extractor de aire automatico en cada piso.
- Aire acondicionado y calefaccion de acuerdo a la ruta.
- Control constante de la unidad a traves de GPS.
- Tomacorrientes en ambos pisos.(exceptuando el servicio Trujillo VIP y Chimbote)
- WIFI a bordo de cortesia segun disponibilidad.
- Servicio de alimentacion a bordo.
- Entretenimiento a traves de peliculas y musica instrumental a bordo.') where idTipoServicio='N';

Update tb_tipoServicio set descripcion=
('- Aire acondicionado y calefaccion de acuerdo a la ruta.
- Servicios higienicos en cada piso, con extractor de aire automatico..
- Control constante de la unidad a traves de GPS.
- Tomacorrientes en ambos pisos.
- WIFI a bordo de cortesia segun disponibilidad.
- Servicio de alimentacion a bordo., que puede consistir en almuerzo, 
	cena, desayuno o snack, de acuerdo al horario de viaje.
- Entretenimiento a traves de peliculas y musica instrumental a bordo.
- Atencion de tripulante de cabina a completa disposicion del pasajero.') where idTipoServicio='V';

Update tb_tipoServicio set descripcion=
('- Limpieza de deshechos solo con agua potable, nada de quimicos.
- Las cabeceras y respaldares suaves, adaptables a la anatomia del pasajero.
- Atencion de tripulante de cabina a completa disposicion del pasajero.
- Entrega de diarios gratuitamente.
- Aire purificador para el salon y servicios higienicos.
- Luz de lectura individualizada.
- Sistema automatico de aire acondicionado y calefaccion.
- Asiento semi cama que reclina 140°
- Pantallas individuales LCD de 10".
- Entrega de audifonos tipo headset individuales.
- INTERNET Wifi toda la ruta.
- PELICULAS Almacena hasta 50 peliculas.') where idTipoServicio='P';

CREATE TABLE IF NOT EXISTS tb_bus(
    nroPlaca CHAR(7) NOT NULL,
    anioFabricacion CHAR(4) NOT NULL,
    marca VARCHAR(20) NOT NULL,
    numAsientos VARCHAR(2) NOT NULL,
    tipoServicio CHAR(1) NOT NULL,
    estado INT NULL DEFAULT NULL,
    foto LONGBLOB NULL DEFAULT NULL,
    PRIMARY KEY (nroPlaca),
    CONSTRAINT fk_tb_bus_1 FOREIGN KEY (tipoServicio)
        REFERENCES tb_tipoServicio (idTipoServicio)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB ;

insert into tb_bus values('UGA-001', '2012', 'Hyundai', '44','N',0,null);
insert into tb_bus values('UGB-002', '2012', 'Hyundai', '44','N',0, null);
insert into tb_bus values('UIC-003', '2012', 'Hyundai', '44' ,'V',0, null);
insert into tb_bus values('VGD-004', '2012', 'Golden Dragon', '44','V',0, null);
insert into tb_bus values('VQE-005', '2013', 'Hyundai', '44','P',0, null);
insert into tb_bus values('VDF-006', '2013', 'Golden Dragon', '44', 'N',0, null);
insert into tb_bus values('UGT-007', '2012', 'HINO', '44','V',0, null);
insert into tb_bus values('VDE-008', '2011', 'King Long', '44', 'N',0, null);
insert into tb_bus values('VRF-009', '2011', 'Golden Dragon', '44', 'N',0, null);
insert into tb_bus values('VTH-010', '2012', 'Hyundai', '44', 'P', 0,null);
insert into tb_bus values('VJY-011', '2011', 'Hyundai', '44', 'N',0, null);
insert into tb_bus values('VDU-012', '2013', 'HINO', '44', 'V',0, null);
insert into tb_bus values('UJI-013', '2012', 'Golden Dragon', '44', 'N',0, null);
insert into tb_bus values('UFO-014', '2011', 'HINO', '44', 'P',0, null);
insert into tb_bus values('UPV-015', '2014', 'Golden Dragon', '44', 'N', 0,null);
insert into tb_bus values('VUA-016', '2013', 'King Long', '44', 'V',0, null);
insert into tb_bus values('UTS-017', '2012', 'Hyundai', '44', 'N',0, null);
insert into tb_bus values('VUD-018', '2011', 'Hyundai', '44', 'N',0, null);
insert into tb_bus values('VOF-019', '2012', 'HINO', '44', 'N',0, null);
insert into tb_bus values('UPG-020', '2014', 'Golden Dragon', '44', 'N',0, null);
insert into tb_bus values('URH-021', '2013', 'Hyundai', '44', 'V',0, null);
insert into tb_bus values('UEJ-022', '2012', 'HINO', '44', 'N',0, null);
insert into tb_bus values('VWL-023', '2011', 'Hyundai', '44', 'V',0, null);
insert into tb_bus values('VTZ-024', '2014', 'Golden Dragon', '44', 'V',0, null);
insert into tb_bus values('UEX-025', '2013', 'Hyundai', '44', 'N',0, null);
insert into tb_bus values('UFC-026', '2012', 'King Long', '44', 'P',0, null);
insert into tb_bus values('VSV-027', '2012', 'Golden Dragon', '44', 'P',0, null);
insert into tb_bus values('VDB-028', '2012', 'Hyundai', '44', 'V',0, null);
insert into tb_bus values('UFN-029', '2011', 'Hyundai', '44', 'N',0, null);
insert into tb_bus values('UMG-030', '2013', 'HINO', '44', 'N',0, null);

CREATE TABLE IF NOT EXISTS tb_ruta (
    codRuta CHAR(5) NOT NULL,
    codCiuOrig CHAR(5) NOT NULL,
    codCiuDest CHAR(5) NOT NULL,
    tarifa DECIMAL(10 , 2 ) NOT NULL,
    horaSalida TIME NULL DEFAULT NULL,
    estado INT NULL DEFAULT NULL,
	/*foto LONGBLOB NULL DEFAULT NULL,*/
    PRIMARY KEY (codRuta),
    CONSTRAINT tb_ruta_ibfk_1 FOREIGN KEY (codCiuOrig)
        REFERENCES tb_ciudad (codCiudad),
    CONSTRAINT tb_ruta_ibfk_2 FOREIGN KEY (codCiuDest)
        REFERENCES tb_ciudad (codCiudad)
)  ENGINE=InnoDB;

insert into tb_ruta values ('RU001', 'CI001', 'CI009',70.0,'20:00', 0);
insert into tb_ruta values ('RU002', 'CI002', 'CI009',100.0,'20:00',0);
insert into tb_ruta values ('RU003', 'CI003', 'CI009',75.0,'20:00', 0);
insert into tb_ruta values ('RU004', 'CI004', 'CI009',45.0,'20:00', 0);
insert into tb_ruta values ('RU005', 'CI005', 'CI009',120.0,'20:00',0);
insert into tb_ruta values ('RU006', 'CI006', 'CI009',50.0,'20:00', 0);
insert into tb_ruta values ('RU007', 'CI007', 'CI009',40.0,'20:00', 0);
insert into tb_ruta values ('RU008', 'CI008', 'CI009',45.0,'20:00', 0);
insert into tb_ruta values ('RU009', 'CI009', 'CI001',70.0,'20:00', 0);
insert into tb_ruta values ('RU010', 'CI009', 'CI002',100.0,'20:00',0);
insert into tb_ruta values ('RU011', 'CI009', 'CI003',75.0,'20:00', 0);
insert into tb_ruta values ('RU012', 'CI009', 'CI004',45.0,'20:00', 0);
insert into tb_ruta values ('RU013', 'CI009', 'CI005',120.0,'20:00',0);
insert into tb_ruta values ('RU014', 'CI009', 'CI006',50.0,'20:00', 0);
insert into tb_ruta values ('RU015', 'CI009', 'CI007',45.0,'20:00', 0);
insert into tb_ruta values ('RU016', 'CI009', 'CI008',40.0,'20:00', 0);

CREATE TABLE IF NOT EXISTS tb_recurso(
    codRecurso CHAR(5) NOT NULL,
    codChofer CHAR(5) NOT NULL,
    codTerramoza CHAR(5) NOT NULL,
    nroPlaca CHAR(7) NOT NULL,
    codRuta CHAR(5) NOT NULL,
    estado INT NULL DEFAULT NULL,
    PRIMARY KEY (codRecurso , codChofer , codTerramoza , nroPlaca , codRuta),
    CONSTRAINT tb_recurso_ibfk_1 FOREIGN KEY (codChofer)
        REFERENCES tb_chofer (codChofer),
    CONSTRAINT tb_recurso_ibfk_2 FOREIGN KEY (codTerramoza)
        REFERENCES tb_terramoza (codTerramoza),
    CONSTRAINT tb_recurso_ibfk_3 FOREIGN KEY (nroPlaca)
        REFERENCES tb_bus (nroPlaca),
    CONSTRAINT tb_recurso_ibfk_4 FOREIGN KEY (codRuta)
        REFERENCES tb_ruta (codRuta)
)  ENGINE=InnoDB;

insert into tb_recurso values ("RC001", 'CH001','TE001', 'UGA-001', 'RU001',0);
insert into tb_recurso values ("RC002", 'CH002','TE002', 'UEX-025', 'RU002',0);
insert into tb_recurso values ("RC003", 'CH003','TE003', 'UFC-026', 'RU003',0);
insert into tb_recurso values ("RC004", 'CH004','TE004', 'UFN-029', 'RU004',0);
insert into tb_recurso values ("RC005", 'CH005','TE005', 'UFO-014', 'RU005',0);
insert into tb_recurso values ("RC006", 'CH006','TE006', 'UIC-003', 'RU006',0);
insert into tb_recurso values ("RC007", 'CH007','TE007', 'UJI-013', 'RU007',0);
insert into tb_recurso values ("RC008", 'CH008','TE008', 'UMG-030', 'RU008',0);
insert into tb_recurso values ("RC009", 'CH009','TE009', 'UPG-020', 'RU009',0);
insert into tb_recurso values ("RC010", 'CH010','TE010', 'UPV-015', 'RU010',0);
insert into tb_recurso values ("RC011", 'CH011','TE011', 'URH-021', 'RU011',0);
insert into tb_recurso values ("RC012", 'CH012','TE012', 'UTS-017', 'RU012',0);
insert into tb_recurso values ("RC013", 'CH013','TE013', 'VDB-028', 'RU013',0);
insert into tb_recurso values ("RC014", 'CH014','TE014', 'VDE-008', 'RU014',0);
insert into tb_recurso values ("RC015", 'CH015','TE015', 'VDF-006', 'RU015',0);
insert into tb_recurso values ("RC016", 'CH016','TE016', 'VDU-012', 'RU016',0);

CREATE TABLE IF NOT EXISTS tb_asientosOcupados (
    codigo INT(11) NOT NULL AUTO_INCREMENT,
    fecha DATE NULL DEFAULT NULL,
    nroPlaca CHAR(7) NOT NULL,
    nroAsiento INT(11) NOT NULL,
    PRIMARY KEY (codigo),
    CONSTRAINT tb_asientosOcupados_ibfk_1 FOREIGN KEY (nroPlaca)
        REFERENCES tb_recurso (nroPlaca),
	CONSTRAINT tb_asientosOcupados_uk unique(fecha,nroPlaca,nroAsiento)
)  ENGINE=InnoDB;
-- Para probar solamente
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2014/12/25','UGA-001', 1);
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2014/12/25','UGA-001', 2);
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2014/12/26','UGA-001', 3);
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2014/12/26','UGA-001', 17);
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2015/01/28','UGA-001', 1);
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2015/01/28','UGA-001', 12);
insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values ('2015/01/28','UGA-001', 19);


CREATE TABLE IF NOT EXISTS tb_cliente (
    codCliente CHAR(5) NOT NULL,
    nomCliente VARCHAR(20) NOT NULL,
    apePaterCliente VARCHAR(20) NOT NULL,
    apeMaterCliente VARCHAR(20) NOT NULL DEFAULT 'X',
    TipoDocumento INT NOT NULL,
    nroDocumentoId VARCHAR(11) NOT NULL,
    sexo CHAR(1) NULL DEFAULT NULL,
    email VARCHAR(40) NOT NULL,
    telef CHAR(9) NOT NULL,
    fechaNac DATE NOT NULL,
    codCiudad CHAR(5) NOT NULL,
    foto LONGBLOB NULL DEFAULT NULL,
    estado INT NULL DEFAULT NULL,
    usuario VARCHAR(15) NOT NULL,
    clave VARCHAR(15) NOT NULL,
    PRIMARY KEY (codCliente),
    CONSTRAINT tb_cliente_ibfk_1 FOREIGN KEY (codCiudad)
        REFERENCES tb_ciudad (codCiudad)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_tb_cliente_1 FOREIGN KEY (TipoDocumento)
        REFERENCES tb_tipoDocumento (idTipoDocumento)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;

insert into tb_cliente values('CL001','Juan', 'Perez','Sanchez', 1, '07126532','M', 'jperez@hotmail.com', '4441111','1985/05/07', 'CI011',null,0,'jperez','1234');
insert into tb_cliente values('CL002','Rodrigo', 'Garcia','Correa', 1, '08872364','M',  'rgarci@hotmail.com', '4442222','1985/05/07', 'CI011',null,0,'rgarcia','1234');
insert into tb_cliente values('CL003','Jesus', 'Zambrano','Torres' ,1, '23654784','M', 'jzambr@hotmail.com', '4443333','1985/05/07', 'CI006',null,0,'jzambrano','1234');
insert into tb_cliente values('CL004','Jose', 'Atuncar','Guzman' ,1, '23654784','M', 'pjatunca@cibertec.edu.pe', '4443333','1985/05/07', 'CI006',null,0,'jatuncar','1234');

CREATE TABLE IF NOT EXISTS tb_boleto (
    nroBoleto CHAR(8) NOT NULL,
    fechaEmision DATE NOT NULL,
    idPasajero varchar(15),
    codCliente CHAR(5) NOT NULL,
    fechaViaje DATE NOT NULL,
    codRecurso CHAR(5) NOT NULL,
    nroAsiento INT(11) NOT NULL,
    precioSol decimal,
    precioDolar decimal,
    PRIMARY KEY (nroBoleto),
    CONSTRAINT tb_boleto_ibfk_1 FOREIGN KEY (codCliente)
        REFERENCES tb_cliente (codCliente),
    CONSTRAINT tb_boleto_ibfk_3 FOREIGN KEY (codRecurso)
        REFERENCES tb_recurso (codRecurso)
)  ENGINE=InnoDB;

insert into tb_boleto values ('BO000001', '2015/01/01','12345678', 'CL001',  '2015/01/10', 'RC001', 11,80,32);



insert into tb_boleto values ('BO000002', '2014/12/20','12345678', 'CL002', '2014/12/23', 'RC002', 20,80,32);
insert into tb_boleto values ('BO000003', '2014/12/20','12345678', 'CL003', '2014/12/23', 'RC002', 21,80,32);
insert into tb_boleto values ('BO000004', '2014/12/23','12345678', 'CL001', '2014/12/26', 'RC004', 31,80,32);
insert into tb_boleto values ('BO000005', '2014/12/27', '12345678','CL003', '2014/12/28', 'RC005', 14,80,32);

insert into tb_boleto values ('BO000006', '2014/12/15','12345678', 'CL003', '2014/12/20', 'RC006', 12,80,32);

insert into tb_boleto values ('BO000007', '2015/01/14','12345678', 'CL002', '2015/01/18', 'RC007', 23,80,32);

insert into tb_boleto values ('BO000008', '2015/01/14','12345678', 'CL002', '2015/01/18', 'RC012', 24,80,32);

insert into tb_boleto values ('BO000009', '2015/02/01','12345678', 'CL001', '2015/02/06', 'RC015', 2,80,32);

insert into tb_boleto values ('BO000010', '2015/02/02','12345678', 'CL002', '2015/02/06', 'RC015', 5,80,32);

insert into tb_boleto values ('BO000011', '2015/02/04', '12345678','CL003', '2015/02/06', 'RC015', 6,80,32);

CREATE TABLE IF NOT EXISTS tb_chofer_bus (
    codChofer CHAR(5) NOT NULL,
    nroPlaca CHAR(7) NOT NULL,
    PRIMARY KEY (codChofer , nroPlaca),
    CONSTRAINT tb_chofer_bus_ibfk_1 FOREIGN KEY (codChofer)
        REFERENCES tb_chofer (codChofer),
    CONSTRAINT tb_chofer_bus_ibfk_2 FOREIGN KEY (nroPlaca)
        REFERENCES tb_bus (nroPlaca)
)  ENGINE=InnoDB;


insert into tb_chofer_bus values ('CH001', 'UGA-001');
insert into tb_chofer_bus values ('CH002', 'UGB-002');

create table if not exists tb_operacion(
	nroCIP int auto_increment primary key,
    fechaOperacion datetime,
	montoTotal decimal
) engine = InnoDB;

ALTER TABLE `tb_operacion` AUTO_INCREMENT = 100000;
create table if not exists tb_detalle_operacion(
	nroCIP int ,
    nroBoleto char(8),
    primary key(nroCIP,nroBoleto),
    CONSTRAINT tb_detalle_operacion_fk FOREIGN KEY (nroBoleto)
        REFERENCES tb_boleto (nroBoleto)
) engine = InnoDB;

insert into tb_operacion values('12345678','2015-01-31',100);
insert into tb_operacion values('87654321','2015-02-02',90);
insert into tb_operacion values('23456789','2015-02-02',90);

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_actualizarBus(xnroPlaca char(7),xanioFabricacion char(4),xmarca varchar(20),xnumAsientos char(2),xtipoServ Char(1),xfoto longblob,xestado int)
begin
	update tb_bus set anioFabricacion= xanioFabricacion, marca= xmarca, numAsientos= xnumAsientos, tipoServicio = xtipoServ,foto=xfoto,estado=xestado where nroPlaca= xnroPlaca;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_actualizarChofer(xcodChofer char(5),xnroLicencia char(9),xnomChofer varchar(20),xapePaterChofer varchar(20),xapeMaterChofer varchar(20),xTipoDocumento char(20),xnroDocumentoId varchar(11),xsexo char(1),xfechaNac date,xemail varchar(25),xtelefono varchar(10),xcodCiudad char(5),xfoto longblob,xestado int)
begin
		update tb_chofer set nroLicencia=xnroLicencia,nomChofer=xnomChofer,apePaterChofer=xapePaterChofer,apeMaterChofer=xapeMaterChofer,TipoDocumento=xTipoDocumento,nroDocumentoId=xnroDocumentoId,sexo=xsexo,fechaNac=xfechaNac,email=xemail,telefono=xtelefono,codCiudad=xcodCiudad,foto=xfoto,estado=xestado where codChofer=xcodChofer;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_actualizarCliente(xcodCliente char(5),xnomCliente varchar(20),xapePaterCliente varchar(10),xapeMaterCliente varchar(20),xTipoDocumento char(20),xnroDocumentoId varchar(11),xsexo char(1),xemail varchar(40),xtelef char(9),xfechaNac date, xcodCiudad char(5),xfoto longblob,xestado int)
begin

	update tb_cliente set nomCliente=xnomCliente,apePaterCliente=xapePaterCliente,apeMaterCliente=xapeMaterCliente,TipoDocumento=xTipoDocumento,nroDocumentoId=xnroDocumentoId,sexo=xsexo,email=xemail,telef=xtelef,fechaNac=xfechaNac,codCiudad=xcodCiudad,foto=xfoto,estado=xestado where codCliente=xcodCliente;	
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_actualizarRutas(xcodRuta char(5),xcodCiuOrig char(5),xcodCiuDest char(5),xtarifa numeric(10,2),xhoraSalida time,/*xfoto longblob,*/xestado int)
begin
	update tb_ruta set codCiuOrig=xcodCiuOrig,codCiuDest=xcodCiuDest,tarifa=xtarifa,horaSalida=xhoraSalida,/*foto=xfoto,*/estado=xestado where codRuta=xcodRuta;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_actualizarTerramoza(xcodTerramoza char(5),xnomTerramoza varchar(20),xapePaterTerramoza varchar(20),xapeMaterTerramoza varchar(20),xTipoDocumento char(20),xnroDocumentoId varchar(11),xsexo char(1),xfechaNac date,xemail varchar(25),xtelefono varchar(10),xcodCiudad char(5),xfoto longblob,xestado int)
begin
		update tb_terramoza set nomTerramoza=xnomTerramoza,apePaterTerramoza=xapePaterTerramoza,apeMaterTerramoza=xapeMaterTerramoza,TipoDocumento=xTipoDocumento,nroDocumentoId=xnroDocumentoId,sexo=xsexo,fechaNac=xfechaNac,email=xemail,telefono=xtelefono,codCiudad=xcodCiudad,foto=xfoto,estado=xestado where codTerramoza=xcodTerramoza;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_eliminarBus(xnroPlaca char(7))
begin
	update tb_bus set estado=1 where nroPlaca= xnroPlaca;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_eliminarChofer(xcodChofer char(5))
begin
		update tb_chofer set estado=1 where codChofer=xcodChofer;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_eliminarCliente(xcodCliente char(5))
begin

	update tb_cliente set estado=1 where codCliente= xcodCliente;	
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_eliminarRecurso(xcodRecurso char(5))
begin
	update tb_recurso set estado=1 where codRecurso= xcodRecurso;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_eliminarRuta(xcodRuta char(5))
begin
	update tb_ruta set estado=1 where codRuta= xcodRuta;	
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_eliminarTerramoza(xcodTerramoza char(5))
begin
		update tb_terramoza set estado=1 where codTerramoza=xcodTerramoza;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_ingresarBus(nroPlaca char(7),anioFabricacion char(4),modelo varchar(20),numAsientos char(2),tipoServ Char(1),foto longblob, estado int)
begin
	insert into tb_bus(nroPlaca, anioFabricacion, marca, numAsientos, tipoServicio,estado,foto)
						values(nroPlaca,anioFabricacion,modelo,numAsientos,tipoServ,estado,foto);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_ingresarChofer(codChofer char(5),nroLicencia char(9),nomChofer varchar(20),apePaterChofer varchar(20),apeMaterChofer varchar(20),TipoDocumento char(20),nroDocumentoId varchar(11),sexo char(1),fechaNac date,email varchar(25),telefono varchar(10),codCiudad char(5),foto longblob,estado int)
begin
	insert into tb_chofer(codChofer,nroLicencia,nomChofer,apePaterChofer,apeMaterChofer,TipoDocumento,nroDocumentoId,sexo,fechaNac,email,telefono,codCiudad,foto,estado) 
					values(codChofer,nroLicencia,nomChofer,apePaterChofer,apeMaterChofer,TipoDocumento,nroDocumentoId,sexo,fechaNac,email,telefono,codCiudad,foto,estado);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_ingresarCliente(codCliente char(5),nomCliente varchar(20),apePaterCliente varchar(10),apeMaterCliente varchar(20),TipoDocumento char(20),nroDocumentoId varchar(11),sexo char(1),email varchar(40),telef char(9),fechaNac date, codCiudad char(5),foto longblob,estado int)
begin
	insert into tb_cliente(codCliente,nomCliente,apePaterCliente,apeMaterCliente,TipoDocumento,nroDocumentoId,sexo,email,telef,fechaNac,codCiudad,foto,estado) 
					values(codCliente,nomCliente,apePaterCliente,apeMaterCliente,TipoDocumento,nroDocumentoId,sexo,email,telef,fechaNac,codCiudad,foto,estado);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_ingresarRecurso(codRecurso char(5), codChofer char(5), codTerramoza char(5), nroPlaca char(7), codRuta char(5),estado int)
begin
	insert into tb_recurso(codRecurso, codChofer, codTerramoza, nroPlaca, codRuta,estado)
						values(codRecurso, codChofer, codTerramoza, nroPlaca, codRuta,estado);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_ingresarRutas(codRuta char(5),codCiuOrig char(5),codCiuDest char(5),tarifa numeric(10,2),horaSalida time,/*foto longblob,*/estado int)
begin
	insert into tb_ruta	values(codRuta,codCiuOrig,codCiuDest,tarifa,horaSalida,/*foto,*/estado);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_ingresarTerramoza(codTerramoza char(5),nomTerramoza varchar(20),apePaterTerramoza varchar(20),apeMaterTerramoza varchar(20),TipoDocumento char(20),nroDocumentoId varchar(11),sexo char(1),fechaNac date,email varchar(25),telefono varchar(10),codCiudad char(5),foto longblob,estado int)
begin
	insert into tb_terramoza(codTerramoza,nomTerramoza,apePaterTerramoza,apeMaterTerramoza,TipoDocumento,nroDocumentoId,sexo,fechaNac,email,telefono,codCiudad,foto,estado) 
					values(codTerramoza,nomTerramoza,apePaterTerramoza,apeMaterTerramoza,TipoDocumento,nroDocumentoId,sexo,fechaNac,email,telefono,codCiudad,foto,estado);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_modificarRecurso(xcodRecurso char(5), xcodChofer char(5), xcodTerramoza char(5), xnroPlaca char(7), xcodRuta char(5),xestado int)
begin
	update tb_recurso set codChofer = xcodChofer, codTerramoza = xcodTerramoza, nroPlaca = xnroPlaca, codRuta = xcodRuta,estado=xestado where codRecurso=xcodRecurso;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_reporteBoletos()
begin
select B.nroBoleto, B.fechaEmision, B.codCounter, B.codCliente, R.codRuta
from tb_boleto B inner join tb_recurso R
on B.codRecurso=R.codRecurso;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE usp_reporteViajes()
begin
select B.fechaViaje, C.codCliente, C.nomCliente, RU.codCiuOrig, RU.codCiuDest
from tb_boleto B inner join tb_cliente C
on B.codCliente = C.codCliente
inner join tb_equipo_ruta R
on B.codRecurso=R.codRecurso
inner join tb_ruta RU
on R.codRuta=RU.codRuta;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost
 trigger TRX_ASIENTOS  BEFORE INSERT
 on tb_boleto
 for each row
 BEGIN
 declare nroPlaca_ char(7);
 select nroPlaca into nroPlaca_ from tb_recurso  where codRecurso = new.codRecurso;
 insert into tb_asientosOcupados(fecha,nroPlaca,nroAsiento) values(new.fechaViaje,nroPlaca_,new.nroAsiento);
END$$

select * from tb_asientosOcupados;

