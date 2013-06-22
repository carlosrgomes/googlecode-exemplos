DROP TABLE IF EXISTS SDE_SERVICO_CBHPM;
DROP TABLE IF EXISTS SDE_SERV_PRODUTO_CBHPM;
DROP TABLE IF EXISTS SDE_CONVERSAO_TUSS;
-- Create table
create table SDE_SERVICO_CBHPM
(
  COD_SERVICO        NUMBER(10) not null,
  DAT_INIC_VIGENCIA  DATE not null,
  NUM_SEQ            NUMBER(4) not null,
  COD_STATUS         CHAR(1),
  DAT_FIM_VIGENCIA   DATE,
  COD_GRUP_ESTAT     NUMBER(5),
  COD_TIPO_US        CHAR(2),
  PCT_MAX_ACRES      NUMBER(5),
  COD_SEXO_SERV      CHAR(1),
  QTD_IDADE_INICIAL  NUMBER(4),
  QTD_IDADE_FINAL    NUMBER(4),
  QTD_MED_DIAS_INTER NUMBER(5),
  FLG_UNITARIO_CONTA CHAR(1),
  QTD_MAX_CTA_NINTER NUMBER(5),
  QTD_MAX_CTA_INTER  NUMBER(5),
  QTD_DIAS_RECORRENC NUMBER(5),
  DAT_INICIO_SERV    DATE,
  COD_SERV_COMUNIC   NUMBER(10),
  FLG_PUBLIC_PERFIL  CHAR(1),
  IDT_PACOTE         CHAR(1),
  COD_SUB_GRUPO_SERV NUMBER(4),
  COD_SUB_GRUPO_AMB  NUMBER(5),
  TMP_MANUTENCAO     DATE,
  FLG_REVISAO_CID    CHAR(1),
  COD_COMPUTADOR     CHAR(12),
  COD_SITUACAO_REG   NUMBER(4),
  TMP_LIBERACAO      DATE,
  COD_INDICATIVO_RX  NUMBER(4),
  DSC_SERVICO_ABREV  VARCHAR2(50),
  COD_TIPO_SERVICO   CHAR(1),
  DSC_SERVICO_COMPL  VARCHAR2(250),
  DAT_MANUT          DATE,
  FLG_SERV_CIRURGICO CHAR(1),
  FLG_TOMOGRAFIA_RES CHAR(1),
  FLG_ANALISE_MEDICA CHAR(1),
  FLG_PREVIA_REEMB   CHAR(1),
  COD_USO            NUMBER(5),
  NME_LOGIN          CHAR(10),
  FLG_BLOQUEIO_ATEND CHAR(1) default 'N' not null,
  IDC_ORIGEM_SERV    CHAR(1),
  FLG_ALTA_COMPLEX   CHAR(1),
  FLG_SERV_TUSS_CRSP CHAR(1)
);

insert into SDE_SERVICO_CBHPM (
  COD_SERVICO          ,
  DAT_INIC_VIGENCIA  ,
  NUM_SEQ            ,
  COD_STATUS         ,
  DAT_FIM_VIGENCIA   ,
  COD_GRUP_ESTAT     ,
  COD_TIPO_US        ,
  PCT_MAX_ACRES      ,
  COD_SEXO_SERV      ,
  QTD_IDADE_INICIAL  ,
  QTD_IDADE_FINAL    ,
  QTD_MED_DIAS_INTER ,
  FLG_UNITARIO_CONTA ,
  QTD_MAX_CTA_NINTER ,
  QTD_MAX_CTA_INTER  ,
  QTD_DIAS_RECORRENC ,
  DAT_INICIO_SERV    ,
  COD_SERV_COMUNIC   ,
  FLG_PUBLIC_PERFIL  ,
  IDT_PACOTE         ,
  COD_SUB_GRUPO_SERV ,
  COD_SUB_GRUPO_AMB  ,
  TMP_MANUTENCAO     ,
  FLG_REVISAO_CID    ,
  COD_COMPUTADOR     ,
  COD_SITUACAO_REG   ,
  TMP_LIBERACAO      ,
  COD_INDICATIVO_RX  ,
  DSC_SERVICO_ABREV  ,
  COD_TIPO_SERVICO   ,
  DSC_SERVICO_COMPL  ,
  DAT_MANUT          ,
  FLG_SERV_CIRURGICO ,
  FLG_TOMOGRAFIA_RES ,
  FLG_ANALISE_MEDICA ,
  FLG_PREVIA_REEMB   ,
  COD_USO           ,
  NME_LOGIN          ,
  FLG_BLOQUEIO_ATEND ,
  IDC_ORIGEM_SERV    ,
  FLG_ALTA_COMPLEX   ,
  FLG_SERV_TUSS_CRSP 

)values

(
1,
  sysdate ,
  1,
  '1',
  '9999-12-31',
  null,
  null,
 null,
 null ,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  5,
  null,
  null,
  'descricao abreviada',
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  'N' ,
  'S',
  null,
  null,
);

-- Create table
create table SDE_SERV_PRODUTO_CBHPM
(
  COD_SERVICO        NUMBER(10) not null,
  COD_PROD           NUMBER(5) not null,
  DAT_INIC_VIGENCIA  DATE not null,
  NUM_SEQ            NUMBER(4) not null,
  COD_STATUS         CHAR(1),
  DAT_FIM_VIGENCIA   DATE,
  FLG_AUTORIZ_PREVIA CHAR(1),
  COD_NIVEL_BLOQUEIO NUMBER(5),
  TMP_MANUTENCAO     DATE,
  COD_ASSIST_MED_PAM CHAR(1),
  FLG_COBERT_INTERN  CHAR(1),
  FLG_COBERT_AMBULA  CHAR(1),
  DAT_INICIO_PROD    DATE,
  COD_COMPUTADOR     CHAR(12),
  COD_TIPO_CARENCIA  CHAR(1),
  COD_SITUACAO_REG   NUMBER(4),
  TMP_LIBERACAO      DATE,
  DAT_MANUT          DATE,
  NME_LOGIN          CHAR(10)
);

insert into SDE_SERV_PRODUTO_CBHPM(
  COD_SERVICO        ,
  COD_PROD           ,
  DAT_INIC_VIGENCIA  ,
  NUM_SEQ            ,
  COD_STATUS         ,
  DAT_FIM_VIGENCIA   ,
  FLG_AUTORIZ_PREVIA ,
  COD_NIVEL_BLOQUEIO ,
  TMP_MANUTENCAO     ,
  COD_ASSIST_MED_PAM ,
  FLG_COBERT_INTERN  ,
  FLG_COBERT_AMBULA  ,
  DAT_INICIO_PROD    ,
  COD_COMPUTADOR     ,
  COD_TIPO_CARENCIA  ,
  COD_SITUACAO_REG   ,
  TMP_LIBERACAO      ,
  DAT_MANUT          ,
  NME_LOGIN          

) values(
  1,
  544,
  sysdate,
  1,
  null,
  '9999-12-31',
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null,
  null
);

create table SDE_CONVERSAO_TUSS
(
  NUM_SEQ_CONV_TUSS  NUMBER(10) not null,
  COD_SERVICO_SAS    NUMBER(10) not null,
  COD_SERVICO_TUSS   NUMBER(10) not null,
  FLG_SERVICO_NOVO   CHAR(1) not null,
  FLG_SERVICO_ELEITO CHAR(1) not null,
  COD_AGRUPAMENTO    CHAR(1) not null,
  DSC_SERVICO_SAS    VARCHAR2(255) not null,
  DSC_SERVICO_TUSS   VARCHAR2(255) not null,
  DAT_INIC_VIGENCIA  DATE not null,
  DAT_FIM_VIGENCIA   DATE not null,
  NME_LOGIN          CHAR(10) not null,
  TMP_MANUTENCAO     TIMESTAMP(6) default SYSTIMESTAMP not null,
  DAT_MANUT          DATE not null
);