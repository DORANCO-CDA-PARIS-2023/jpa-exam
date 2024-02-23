DROP DATABASE IF EXISTS System_Hotelerie;
CREATE DATABASE System_Hotelerie;

USE System_Hotelerie;

create table CHAMBRE 
(
   ID_CHAMBRE           integer                        not null,
   ID_HOTEL             integer                        not null,
   NUMERO               integer                        null,
   TYPE                 long varchar                   null,
   PRIX                 decimal                        null,
   constraint PK_CHAMBRE primary key (ID_CHAMBRE)
);

create unique index CHAMBRE_PK on CHAMBRE (
ID_CHAMBRE ASC
);

create index CONTIENT_FK on CHAMBRE (
ID_HOTEL ASC
);

create table CLIENT 
(
   ID_CLIENT            integer                        not null,
   PRENOM               long varchar                   null,
   NOM                  long varchar                   null,
   ADRESSE              long varchar                   null,
   TELEPHONE            long varchar                   null,
   constraint PK_CLIENT primary key (ID_CLIENT)
);

create unique index CLIENT_PK on CLIENT (
ID_CLIENT ASC
);

create table EMPLOYE 
(
   ID_EMPLOYE           integer                        not null,
   ID_HOTEL             integer                        not null,
   NOM                  long varchar                   null,
   PRENOM               long varchar                   null,
   POSTE                long varchar                   null,
   constraint PK_EMPLOYE primary key (ID_EMPLOYE)
);

create unique index EMPLOYE_PK on EMPLOYE (
ID_EMPLOYE ASC
);

create index EMBAUCHE_FK on EMPLOYE (
ID_HOTEL ASC
);

create table FACTURE 
(
   ID_FACTURE           integer                        not null,
   MONTANT              decimal                        null,
   constraint PK_FACTURE primary key (ID_FACTURE)
);

create unique index FACTURE_PK on FACTURE (
ID_FACTURE ASC
);

create table HOTEL 
(
   ID_HOTEL             integer                        not null,
   NOM                  long varchar                   null,
   ADRESSE              long varchar                   null,
   NB_CAMBRE            integer                        null,
   constraint PK_HOTEL primary key (ID_HOTEL)
);

create unique index HOTEL_PK on HOTEL (
ID_HOTEL ASC
);

create table RESERVATIONCHAMBRE 
(
   ID_HOTEL             integer                        not null,
   ID_CLIENT            integer                        not null,
   ID_FACTURE           integer                        not null,
   DATEDEBUT            date                           null,
   DATEFIN              date                           null,
   constraint PK_RESERVATIONCHAMBRE primary key clustered (ID_HOTEL, ID_CLIENT, ID_FACTURE)
);

create index RESERVATIONCHAMBRE_FK on RESERVATIONCHAMBRE (
ID_HOTEL ASC
);

create index RESERVATIONCHAMBRE2_FK on RESERVATIONCHAMBRE (
ID_CLIENT ASC
);

create index RESERVATIONCHAMBRE3_FK on RESERVATIONCHAMBRE (
ID_FACTURE ASC
);

create table SERVICE 
(
   ID_SERVICE           integer                        not null,
   ID_HOTEL             integer                        not null,
   NOM                  long varchar                   null,
   constraint PK_SERVICE primary key (ID_SERVICE)
);

create unique index SERVICE_PK on SERVICE (
ID_SERVICE ASC
);

create index PROPOSE_FK on SERVICE (
ID_HOTEL ASC
);

alter table CHAMBRE
   add constraint FK_CHAMBRE_CONTIENT_HOTEL foreign key (ID_HOTEL)
      references HOTEL (ID_HOTEL)
      on update restrict
      on delete restrict;

alter table EMPLOYE
   add constraint FK_EMPLOYE_EMBAUCHE_HOTEL foreign key (ID_HOTEL)
      references HOTEL (ID_HOTEL)
      on update restrict
      on delete restrict;

alter table RESERVATIONCHAMBRE
   add constraint FK_RESERVAT_RESERVATI_HOTEL foreign key (ID_HOTEL)
      references HOTEL (ID_HOTEL)
      on update restrict
      on delete restrict;

alter table RESERVATIONCHAMBRE
   add constraint FK_RESERVAT_RESERVATI_CLIENT foreign key (ID_CLIENT)
      references CLIENT (ID_CLIENT)
      on update restrict
      on delete restrict;

alter table RESERVATIONCHAMBRE
   add constraint FK_RESERVAT_RESERVATI_FACTURE foreign key (ID_FACTURE)
      references FACTURE (ID_FACTURE)
      on update restrict
      on delete restrict;

alter table SERVICE
   add constraint FK_SERVICE_PROPOSE_HOTEL foreign key (ID_HOTEL)
      references HOTEL (ID_HOTEL)
      on update restrict
      on delete restrict;

