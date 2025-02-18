#include <SPI.h>


// Команды
/////////////////////////////////////////////////////////////////// Управление питанием "5V-OK"
String OK_5Vs_ON  =  "OK;5Vs;ON;" ;
// Answers
String OK_5Vs_ON_Good  =  "OK;5Vs;ON;Good;" ;
String OK_5Vs_ON_Error_5V_RK_ON  =  "OK;5Vs;ON;Error_5V_RK_ON;" ;

String OK_5Vs_OFF = "OK;5Vs;OFF;" ;
// Answers
String OK_5Vs_OFF_Good  = "OK;5Vs;OFF;Good;" ;
String OK_5Vs_OFF_Error_5V_RK_ON   = "OK;5Vs;OFF;Error_5V_RK_ON;" ; 


/////////////////////////////////////////////////////////////////// Управление питанием "5V-RK"
String RK_5Vs_ON = "RK;5Vs;ON;" ;
// Answers
String RK_5Vs_ON_Good  = "RK;5Vs;ON;Good;" ;
String RK_5Vs_ON_Error_5V_OK_ON  = "RK;5Vs;ON;Error_5V_OK_ON;" ;

String RK_5Vs_OFF = "RK;5Vs;OFF;" ;
// Answers
String RK_5Vs_OFF_Good = "RK;5Vs;OFF;Good;" ;
String RK_5Vs_OFF_Error_5V_OK_ON = "RK;5Vs;OFF;Error_5V_OK_ON;" ;


/////////////////////////////////////////////////////////////////// Управление питанием усилителей основным каналом управления
String OK_VKL_4V_osn_1_ON = "OK;VKL_4V_osn_1;ON; " ;
// Answers
String OK_VKL_4V_osn_1_ON_Good = "OK;VKL_4V_osn_1;ON;Good;" ;
String OK_VKL_4V_osn_1_ON_Error_5V_OK_OFF = "OK;VKL_4V_osn_1;ON;Error_5V_OK_OFF;" ;
String OK_VKL_4V_osn_1_ON_Error_4V_res_1_ON = "OK;VKL_4V_osn_1;ON;Error_4V_res_1_ON;" ;

String OK_VKL_4V_osn_1_OFF = "OK;VKL_4V_osn_1;OFF;" ;  
// Answers
String OK_VKL_4V_osn_1_OFF_Good = "OK;VKL_4V_osn_1;OFF;Good;" ;
String OK_VKL_4V_osn_1_OFF_Error_5V_OK_OFF = "OK;VKL_4V_osn_1;OFF;Error_5V_OK_OFF;" ;
String OK_VKL_4V_osn_1_OFF_Error_4V_res_1_ON = "OK;VKL_4V_osn_1;OFF;Error_4V_res_1_ON;" ;
  
String OK_VKL_4V_res_1_ON = "OK;VKL_4V_res_1;ON;" ;
// Answers
String OK_VKL_4V_res_1_ON_Good = "OK;VKL_4V_res_1;ON;Good;" ;
String OK_VKL_4V_res_1_ON_Error_5V_OK_OFF = "OK;VKL_4V_res_1;ON;Error_5V_OK_OFF;" ;
String OK_VKL_4V_res_1_ON_Error_4V_osn_1_ON = "OK;VKL_4V_res_1;ON;Error_4V_osn_1_ON;" ;

String OK_VKL_4V_res_1_OFF = "OK;VKL_4V_res_1;OFF;" ;
// Answers
String OK_VKL_4V_res_1_OFF_Good = "OK;VKL_4V_res_1;OFF;Good;" ;
String OK_VKL_4V_res_1_OFF_Error_5V_OK_OFF = "OK;VKL_4V_res_1;OFF;Error_5V_OK_OFF;" ;
String OK_VKL_4V_res_1_OFF_Error_4V_osn_1_ON = "OK;VKL_4V_res_1;OFF;Error_4V_osn_1_ON;" ;


/////////////////////////////////////////////////////////////////// Управление питанием усилителей резервным каналом управления
String RK_VKL_4V_osn_2_ON = "RK;VKL_4V_osn_2;ON;" ;
//Answers  
String RK_VKL_4V_osn_2_ON_Good = "RK;VKL_4V_osn_2;ON;Good;" ;
String RK_VKL_4V_osn_2_ON_Error_5V_RK_OFF = "RK;VKL_4V_osn_2;ON;Error_5V_RK_OFF;" ;
String RK_VKL_4V_osn_2_ON_Error_4V_res_2_ON = "RK;VKL_4V_osn_2;ON;Error_4V_res_2_ON;" ;
  
String RK_VKL_4V_osn_2_OFF  = "RK;VKL_4V_osn_2;OFF;" ;
//Answers 
String RK_VKL_4V_osn_2_OFF_Good  = "RK;VKL_4V_osn_2;OFF;Good;" ;
String RK_VKL_4V_osn_2_OFF_Error_5V_RK_OFF  = "RK;VKL_4V_osn_2;OFF;Error_5V_RK_OFF;" ;
String RK_VKL_4V_osn_2_OFF_Error_4V_res_2_ON  = "RK;VKL_4V_osn_2;OFF;Error_4V_res_2_ON;" ;

String RK_VKL_4V_res_2_ON = "RK;VKL_4V_res_2;ON;" ;
//Answers 
String RK_VKL_4V_res_2_ON_Good = "RK;VKL_4V_res_2;ON;Good;" ;
String RK_VKL_4V_res_2_ON_Error_5V_RK_OFF = "RK;VKL_4V_res_2;ON;Error_5V_RK_OFF;" ;
String RK_VKL_4V_res_2_ON_Error_4V_osn_2_ON = "RK;VKL_4V_res_2;ON;Error_4V_osn_2_ON;" ;

String RK_VKL_4V_res_2_OFF = "RK;VKL_4V_res_2;OFF;" ;  
//Answers 
String RK_VKL_4V_res_2_OFF_Good = "RK;VKL_4V_res_2;OFF;Good;" ;
String RK_VKL_4V_res_2_OFF_Error_5V_RK_OFF = "RK;VKL_4V_res_2;OFF;Error_5V_RK_OFF;" ;
String RK_VKL_4V_res_2_OFF_Error_4V_osn_2_ON = "RK;VKL_4V_res_2;OFF;Error_4V_osn_2_ON;" ;


/////////////////////////////////////////////////////////////////// Управление телеметрией детекторов мощности основного канала управления
String OK_TM = "OK;TM;" ;
String OK_TM_DM0 = "OK;TM;DM0;" ;
String OK_TM_DM1 = "OK;TM;DM1;" ;
String OK_TM_DM2 = "OK;TM;DM2;" ;
String OK_TM_DM3 = "OK;TM;DM3;" ;
String OK_TM_DM4 = "OK;TM;DM4;" ;
String OK_TM_DM5 = "OK;TM;DM5;" ;
String OK_TM_DM6 = "OK;TM;DM6;" ;
String OK_TM_DM7 = "OK;TM;DM7;" ;
String OK_TM_DM8 = "OK;TM;DM8;" ;
String OK_TM_DM9 = "OK;TM;DM9;" ;
String OK_TM_DM10 = "OK;TM;DM10;" ;
String OK_TM_DM11 = "OK;TM;DM11;" ;
String OK_TM_DM12 = "OK;TM;DM12;" ;
String OK_TM_DM13 = "OK;TM;DM13;" ;
String OK_TM_DM14 = "OK;TM;DM14;" ;
String OK_TM_DM15 = "OK;TM;DM15;" ;
//Error answer
String OK_TM_Error_5V_OK_OFF  = "OK;TM;Error_5V_OK_OFF;" ;


/////////////////////////////////////////////////////////////////// Управление телеметрией детекторов мощности резервного канала управления
String RK_TM = "RK;TM;" ;
String RK_TM_DM0 = "RK;TM;DM0;" ;
String RK_TM_DM1 = "RK;TM;DM1;" ;
String RK_TM_DM2 = "RK;TM;DM2;" ;
String RK_TM_DM3 = "RK;TM;DM3;" ;
String RK_TM_DM4 = "RK;TM;DM4;" ;
String RK_TM_DM5 = "RK;TM;DM5;" ;
String RK_TM_DM6 = "RK;TM;DM6;" ;
String RK_TM_DM7 = "RK;TM;DM7;" ;
String RK_TM_DM8 = "RK;TM;DM8;" ;
String RK_TM_DM9 = "RK;TM;DM9;" ;
String RK_TM_DM10 = "RK;TM;DM10;" ;
String RK_TM_DM11 = "RK;TM;DM11;" ;
String RK_TM_DM12 = "RK;TM;DM12;" ;
String RK_TM_DM13 = "RK;TM;DM13;" ;
String RK_TM_DM14 = "RK;TM;DM14;" ;
String RK_TM_DM15 = "RK;TM;DM15;" ;
//Error answer
String RK_TM_Error_5V_RK_OFF  = "RK;TM;Error_5V_RK_OFF;" ;


/////////////////////////////////////////////////////////////////// Управление телеметрией основного питания
String OK_TM_5Vout1  = "OK;TM;5Vout1;" ;
String OK_TM_4V_2_2  = "OK;TM;4V_2_2;" ;
String OK_TM_4V_1_2  = "OK;TM;4V_1_2;" ;
String OK_TM_4V_2_1  = "OK;TM;4V_2_1;" ;
String OK_TM_4V_1_1  = "OK;TM;4V_1_1;" ;
String OK_TM_4V_2out  = "OK;TM;4V_2out;" ;
String OK_TM_4V_1out  = "OK;TM;4V_1out;" ;
String OK_TM_GND  = "OK;TM;GND;" ;
String OK_TM_Neg5Vout1  = "OK;TM;Neg5Vout1;" ;
String OK_TM_TEMP1  = "OK;TM;TEMP1;" ;
String OK_TM_TEMP1_C  = "OK;TM;TEMP1_C;" ;
//Error answer
//OK_TM_Error_5V_OK_OFF 


/////////////////////////////////////////////////////////////////// Управление телеметрией резервного питания
String RK_TM_5Vout2  = "RK;TM;5Vout2;" ;
String RK_TM_4V_2_2  = "RK;TM;4V_2_2;" ;
String RK_TM_4V_1_2  = "RK;TM;4V_1_2;" ;
String RK_TM_4V_2_1  = "RK;TM;4V_2_1;" ;
String RK_TM_4V_1_1  = "RK;TM;4V_1_1;" ;
String RK_TM_4V_2out  = "RK;TM;4V_2out;" ;
String RK_TM_4V_1out  = "RK;TM;4V_1out;" ;
String RK_TM_GND  = "RK;TM;GND;" ;
String RK_TM_Neg5Vout2  = "RK;TM;Neg5Vout2;" ;
String RK_TM_TEMP2  = "RK;TM;TEMP2;" ;
String RK_TM_TEMP2_C  = "RK;TM;TEMP2_C;" ; 
//Error answer
//RK_TM_Error_5V_RK_OFF


/////////////////////////////////////////////////////////////////// Получение доступной телеметрии в автоматическом режиме
String OK_TM_AutoON  = "OK;TM;AutoON;" ;
//Answer
String OK_TM_AutoON_Good  = "OK;TM;AutoON;Good;" ;
String OK_TM_AutoON_Error_5V_OK_OFF  = "OK;TM;AutoON;Error_5V_OK_OFF;" ;

String OK_TM_AutoOFF  = "OK;TM;AutoOFF;" ;
//Answer
String OK_TM_AutoOFF_Good  = "OK;TM;AutoOFF;Good;" ;
String OK_TM_AutoOFF_Error_5V_OK_OFF  = "OK;TM;AutoON;Error_5V_OK_OFF;" ;

String RK_TM_AutoON  = "RK;TM;AutoON;" ;
//Answer
String RK_TM_AutoON_Good  = "RK;TM;AutoON;Good;" ;
String RK_TM_AutoON_Error_5V_RK_OFF  = "RK;TM;AutoON;Error_5V_RK_OFF;" ;

String RK_TM_AutoOFF  = "RK;TM;AutoOFF;" ;
//Answer
String RK_TM_AutoOFF_Good  = "RK;TM;AutoOFF;Good;" ;
String RK_TM_AutoOFF_Error_5V_RK_OFF  = "RK;TM;AutoON;Error_5V_RK_OFF;" ;


/////////////////////////////////////////////////////////////////// Управление аттенюатором основной канал управления
String OK_Att = "OK;Att;" ;
String OK_Att_0_0_dB  = "OK;Att;0.0 dB;" ;
String OK_Att_0_5_dB  = "OK;Att;0.5 dB;" ;
String OK_Att_1_0_dB  = "OK;Att;1.0 dB;" ;
String OK_Att_1_5_dB  = "OK;Att;1.5 dB;" ;
String OK_Att_2_0_dB  = "OK;Att;2.0 dB;" ;
String OK_Att_2_5_dB  = "OK;Att;2.5 dB;" ;
String OK_Att_3_0_dB  = "OK;Att;3.0 dB;" ;
String OK_Att_3_5_dB  = "OK;Att;3.5 dB;" ;
String OK_Att_4_0_dB  = "OK;Att;4.0 dB;" ;
String OK_Att_4_5_dB  = "OK;Att;4.5 dB;" ;
String OK_Att_5_0_dB  = "OK;Att;5.0 dB;" ;
String OK_Att_5_5_dB  = "OK;Att;5.5 dB;" ;
String OK_Att_6_0_dB  = "OK;Att;6.0 dB;" ;
String OK_Att_6_5_dB  = "OK;Att;6.5 dB;" ;
String OK_Att_7_0_dB  = "OK;Att;7.0 dB;" ;
String OK_Att_7_5_dB  = "OK;Att;7.5 dB;" ;
String OK_Att_8_0_dB  = "OK;Att;8.0 dB;" ;
String OK_Att_8_5_dB  = "OK;Att;8.5 dB;" ;
String OK_Att_9_0_dB  = "OK;Att;9.0 dB;" ;
String OK_Att_9_5_dB  = "OK;Att;9.5 dB;" ;
String OK_Att_10_0_dB  = "OK;Att;10.0 dB;" ;
String OK_Att_10_5_dB  = "OK;Att;10.5 dB;" ;
String OK_Att_11_0_dB  = "OK;Att;11.0 dB;" ;
String OK_Att_11_5_dB  = "OK;Att;11.5 dB;" ;
String OK_Att_12_0_dB  = "OK;Att;12.0 dB;" ;
String OK_Att_12_5_dB  = "OK;Att;12.5 dB;" ;
String OK_Att_13_0_dB  = "OK;Att;13.0 dB;" ;
String OK_Att_13_5_dB  = "OK;Att;13.5 dB;" ;
String OK_Att_14_0_dB  = "OK;Att;14.0 dB; " ;
String OK_Att_14_5_dB  = "OK;Att;14.5 dB;" ;
String OK_Att_15_0_dB  = "OK;Att;15.0 dB;" ;
String OK_Att_15_5_dB  = "OK;Att;15.5 dB;" ;
//Error answer
String OK_Att_Error_5V_OK_OFF   = "OK;Att;Error_5V_ OK_OFF;" ;


/////////////////////////////////////////////////////////////////// Управление аттенюатором резервный канал управления
String RK_Att = "RK;Att;" ;
String RK_Att_0_0_dB  = "RK;Att;0.0 dB;" ;
String RK_Att_0_5_dB  = "RK;Att;0.5 dB;" ;
String RK_Att_1_0_dB  = "RK;Att;1.0 dB;" ;
String RK_Att_1_5_dB  = "RK;Att;1.5 dB;" ;
String RK_Att_2_0_dB  = "RK;Att;2.0 dB;" ;
String RK_Att_2_5_dB  = "RK;Att;2.5 dB;" ;
String RK_Att_3_0_dB  = "RK;Att;3.0 dB;" ;
String RK_Att_3_5_dB  = "RK;Att;3.5 dB;" ;
String RK_Att_4_0_dB  = "RK;Att;4.0 dB;" ;
String RK_Att_4_5_dB  = "RK;Att;4.5 dB;" ;
String RK_Att_5_0_dB  = "RK;Att;5.0 dB;" ;
String RK_Att_5_5_dB  = "RK;Att;5.5 dB;" ;
String RK_Att_6_0_dB  = "RK;Att;6.0 dB;" ;
String RK_Att_6_5_dB  = "RK;Att;6.5 dB;" ;
String RK_Att_7_0_dB  = "RK;Att;7.0 dB;" ;
String RK_Att_7_5_dB  = "RK;Att;7.5 dB;" ;
String RK_Att_8_0_dB  = "RK;Att;8.0 dB;" ;
String RK_Att_8_5_dB  = "RK;Att;8.5 dB;" ;
String RK_Att_9_0_dB  = "RK;Att;9.0 dB;" ;
String RK_Att_9_5_dB  = "RK;Att;9.5 dB;" ;
String RK_Att_10_0_dB  = "RK;Att;10.0 dB;" ;
String RK_Att_10_5_dB  = "RK;Att;10.5 dB;" ;
String RK_Att_11_0_dB  = "RK;Att;11.0 dB;" ;
String RK_Att_11_5_dB  = "RK;Att;11.5 dB;" ;
String RK_Att_12_0_dB  = "RK;Att;12.0 dB;" ;
String RK_Att_12_5_dB  = "RK;Att;12.5 dB;" ;
String RK_Att_13_0_dB  = "RK;Att;13.0 dB;" ;
String RK_Att_13_5_dB  = "RK;Att;13.5 dB;" ;
String RK_Att_14_0_dB  = "RK;Att;14.0 dB; " ;
String RK_Att_14_5_dB  = "RK;Att;14.5 dB;" ;
String RK_Att_15_0_dB  = "RK;Att;15.0 dB;" ;
String RK_Att_15_5_dB  = "RK;Att;15.5 dB;" ;
//Error answer
String RK_Att_Error_5V_RK_OFF   = "RK;Att;Error_5V_ RK_OFF;" ;


/////////////////////////////////////////////////////////////////// Управление светодиодами, получение версии ПО
String LED_ON = "LED;ON;";
//Answer
String LED_ON_Good = "LED;ON;Good;" ;

String LED_OFF  = "LED;OFF;" ;
//Answer
String LED_OFF_Good  = "LED;OFF;Good;" ;

String VERSION_GET  = "VERSION;GET;" ;
String version = "VERSION;GET;1.0;";
///////////////////////////////////////////////////////////////////
String good = "Good;";

////////////////////////////////////////////////////////////////// Переменные для обеспечения логики работы/состояния блока
boolean is5Vs_OK = false;             // ВКЛ-1
boolean is5Vs_RK = false;             // ВКЛ-2

boolean isVKL_4V_osn1  = false;       // ВКЛ_4Vосн1
boolean isVKL_4V_res1  = false;       // ВКЛ_4Vрез1

boolean isVKL_4V_osn2  = false;       // ВКЛ_4Vосн2
boolean isVKL_4V_res2  = false;       // ВКЛ_4Vрез2

boolean isAutoTM_OK = false;          // Включение автоматического получения ТМ основного канала управления
boolean isAutoTM_RK = false;          // Включение автоматического получения ТМ резервного канала управления

boolean states[8];                    // состояния блока
String command = "";                  // команда на вход блока


// Настройки порта
int delaySerialPrint = 1500;
int serialBaudRate = 9600;


// Настройки таймеров
uint32_t timerReadPort;
uint32_t timerReadPortDelay = 400;

uint32_t timer_OK_TM, timer_RK_TM;
uint32_t timer_TM_Delay = 300;

// Телеметрия   
int tm_OK_counter = 0;                    // Счетчик для перебора цепей телеметрии основного канала
int tm_OK_counter_MAX_VALUE = 27;         // Количество цепей телеметрии
String tmOk[27];                          // Массив хранит команды для получения телеметрии

int tm_RK_counter = 0;
int tm_RK_counter_MAX_VALUE = 27;
String tmRk[27];

//
int timer_RegisterOK = 300;
int timer_RegisterRK = 300;

////////////////////////////////////////////////////////////////////////////////Настройки для работы с пультом
//Светодиод контроль пульта
int LED_CONTROL = 41;

//Настойка регистра для основного канала
//Пин подключен к DS 
int DS_OK = 51;
//Пин подключен к SH_CP 
int SH_CP_OK = 49;
//Пин подключен к ST_CP
int ST_CP_OK = 47;
//Пин подключен к OE
int OE_OK = 45;


//Настойка регистра для резервного канала
//Пин подключен к DS 
int DS_RK = 37;
//Пин подключен к SH_CP 
int SH_CP_RK = 35;
//Пин подключен к ST_CP
int ST_CP_RK = 33;
//Пин подключен к OE
int OE_RK = 31;


//АЦП Основного канала
int ADC_OK = A0;
//АЦП Резервного канала
int ADC_RK = A5;


//Включение ВКЛ-1 и ВКЛ2
int VKL_1 = 26;                 // ВКЛ-1
int VKL_2 = 24;                 // ВКЛ-2

//Управление буферами
int EN_SPI_OK = 4;
int EN_SPI_RK = 6;
int EN_REG_OK = 5;
int EN_REG_RK = 7;

//Установка режимов SPI
SPISettings settingsA(1000000, MSBFIRST, SPI_MODE0);
//int SS = 53;
//Пин подключен к LE
int LE = 40;

// Для расчета температуры
double alpha = 0.01;    // значение темпертурного коэффициента напряжения здесь В/K




//////////////////////////////////////////////////////////////////////////////////////////////// Иициализация
void initState(){
    states[0] = is5Vs_OK;             // ВКЛ-1
    states[1] = is5Vs_RK;             // ВКЛ-2

    states[2] = isVKL_4V_osn1;        // ВКЛ_4Vосн1           
    states[3] = isVKL_4V_res1;        // ВКЛ_4Vрез1
   
    states[4] = isVKL_4V_osn2;          // ВКЛ_4Vосн2
    states[5] = isVKL_4V_res2;       // ВКЛ_4Vрез2

    states[6] = isAutoTM_OK;          // Включение автоматического получения ТМ основного канала управления
    states[7] = isAutoTM_RK;          // Включение автоматического получения ТМ резервного канала управления

    Serial.begin(serialBaudRate);  // Открываем порт на скорости 9600 бод.
}

//////////////////////////////////////////////////////////////////////////////////////////////// Массив с командами телеметрии основного канала
void setTM_OK(){
    tmOk[0] = OK_TM_DM0 ;
    tmOk[1] = OK_TM_DM1 ;
    tmOk[2] = OK_TM_DM2 ;
    tmOk[3] = OK_TM_DM3 ;
    tmOk[4] = OK_TM_DM4 ;
    tmOk[5] = OK_TM_DM5 ;
    tmOk[6] = OK_TM_DM6 ;
    tmOk[7] = OK_TM_DM7 ;
    
    tmOk[8] = OK_TM_DM8 ;
    tmOk[9] = OK_TM_DM9 ;
    tmOk[10] = OK_TM_DM10 ;
    tmOk[11] = OK_TM_DM11 ;
    tmOk[12] = OK_TM_DM12 ;
    tmOk[13] = OK_TM_DM13 ;
    tmOk[14] = OK_TM_DM14 ;
    tmOk[15] = OK_TM_DM15 ;
    
    tmOk[16] = OK_TM_5Vout1 ;
    tmOk[17] = OK_TM_4V_2_2 ;
    tmOk[18] = OK_TM_4V_1_2 ;
    tmOk[19] = OK_TM_4V_2_1 ;
    tmOk[20] = OK_TM_4V_1_1 ;
    
    tmOk[21] = OK_TM_4V_2out ;
    tmOk[22] = OK_TM_4V_1out ;
    tmOk[23] = OK_TM_GND ;
    tmOk[24] = OK_TM_Neg5Vout1 ;
    tmOk[25] = OK_TM_TEMP1 ;   
    tmOk[26] = OK_TM_TEMP1_C ;                                   
}

//////////////////////////////////////////////////////////////////////////////////////////////// Массив с командами телеметрии резервного канала
void setTM_RK(){
    tmRk[0] = RK_TM_DM0; 
    tmRk[1] = RK_TM_DM1; 
    tmRk[2] = RK_TM_DM2; 
    tmRk[3] = RK_TM_DM3; 
    tmRk[4] = RK_TM_DM4; 
    tmRk[5] = RK_TM_DM5; 
    tmRk[6] = RK_TM_DM6; 
    tmRk[7] = RK_TM_DM7; 
    
    tmRk[8] = RK_TM_DM8; 
    tmRk[9] = RK_TM_DM9; 
    tmRk[10] = RK_TM_DM10; 
    tmRk[11] = RK_TM_DM11; 
    tmRk[12] = RK_TM_DM12; 
    tmRk[13] = RK_TM_DM13; 
    tmRk[14] = RK_TM_DM14; 
    tmRk[15] = RK_TM_DM15; 
    
    tmRk[16] = RK_TM_5Vout2 ;
    tmRk[17] = RK_TM_4V_2_2 ;
    tmRk[18] = RK_TM_4V_1_2 ;
    tmRk[19] = RK_TM_4V_2_1 ;
    tmRk[20] = RK_TM_4V_1_1 ;;
    tmRk[21] = RK_TM_4V_2out ;
    tmRk[22] = RK_TM_4V_1out ;
    tmRk[23] = RK_TM_GND ;
    tmRk[24] = RK_TM_Neg5Vout2 ;
    tmRk[25] = RK_TM_TEMP2 ;      
    tmRk[26] = RK_TM_TEMP2_C ;                              
}

//////////////////////////////////////////////////////////////////////////////////////////////// Настройки выводов на вход/выход
void setupPins(){
    
    //устанавливаем режим OUTPUT
    pinMode(LED_CONTROL, OUTPUT);
    digitalWrite(LED_CONTROL, LOW);
    
    //для основного канала
    pinMode(DS_OK, OUTPUT);
    pinMode(SH_CP_OK, OUTPUT);
    pinMode(ST_CP_OK, OUTPUT);
    pinMode(OE_OK, OUTPUT);
    digitalWrite(DS_OK, LOW);
    digitalWrite(SH_CP_OK, LOW);
    digitalWrite(ST_CP_OK, LOW);
    digitalWrite(OE_OK, HIGH);  // Высокий уровень регистры в Z-состоянии

        
    //для резервного канала
    pinMode(DS_RK, OUTPUT);
    pinMode(SH_CP_RK, OUTPUT);
    pinMode(ST_CP_RK, OUTPUT);
    pinMode(OE_RK, OUTPUT);
    digitalWrite(DS_RK, LOW);
    digitalWrite(SH_CP_RK, LOW);
    digitalWrite(ST_CP_RK, LOW);
    digitalWrite(OE_RK, HIGH);  // Высокий уровень регистры в Z-состоянии
    
    // Задаем опорное значение напряжения для АЦП.
    pinMode(ADC_OK, INPUT );
    pinMode(ADC_RK, INPUT );
   //pinMode(ADC_OK, INPUT_PULLUP);
   //pinMode(ADC_RK, INPUT_PULLUP);
      
    //Для включения ВКЛ-1 и ВКЛ2 
    pinMode(VKL_1, OUTPUT);
    pinMode(VKL_2, OUTPUT);
    digitalWrite(VKL_1, LOW);
    digitalWrite(VKL_2, LOW);
    
    //Для управления буферами
    pinMode(EN_SPI_OK, OUTPUT);
    pinMode(EN_SPI_RK, OUTPUT);
    pinMode(EN_REG_OK, OUTPUT);
    pinMode(EN_REG_RK, OUTPUT);
    digitalWrite(EN_SPI_OK, HIGH);    // Высокий уровень - запрет на передачу
    digitalWrite(EN_SPI_RK, HIGH);    // Высокий уровень - запрет на передачу
    digitalWrite(EN_REG_OK, LOW);
    digitalWrite(EN_REG_RK, LOW);
    
    // Для управления SPI
    SPI.begin();
    SPI.beginTransaction(settingsA);
    SPI.setClockDivider(SS, 84);
    //
    pinMode(LE, OUTPUT);
    digitalWrite(LE, LOW);

}


//////////////////////////////////////////// setup
void setup(){
    initState();
    setTM_OK();
    setTM_RK();
    setupPins();
}


void loop(){

    if (millis() - timerReadPort >= /*timerReadPortDelay*/ timer_TM_Delay ) {         // чтение порта
        timerReadPort = millis();                                  // сброс таймера
        readFromPort();
    }


    if (millis() - timer_OK_TM >= timer_TM_Delay) {                 // для перебора цепей телеметрии основного канала
        timer_OK_TM = millis();                                     // сброс таймера
     
        if(isAutoTM_OK) {                                           // Получение ТМ основного канала в автоматическом режиме
            //printTmByCommand_OK( tmOk[tm_OK_counter] );                   // Вывод текущего значения ТМ и далее перебор  
            setCommand(tmOk[tm_OK_counter]);
            tm_OK_counter++;          
            if( tm_OK_counter == tm_OK_counter_MAX_VALUE  ){
                tm_OK_counter = 0;
            }
        }
    }


    if (millis() - timer_RK_TM >= timer_TM_Delay) {                 // для перебора цепей телеметрии основного канала
        timer_RK_TM = millis();                                     // сброс таймера
        
        if(isAutoTM_RK) {
            printTmByCommand_RK( tmRk[tm_RK_counter] );                   // Получение ТМ резервного канала в автоматическом режиме
            tm_RK_counter++;                                        // Вывод текущего значения ТМ и далее перебор
            if( tm_RK_counter == tm_RK_counter_MAX_VALUE  ){
                tm_RK_counter = 0;
            }
        }
    }
    

}



void readFromPort(){

    if(Serial.available()){
        char ch = Serial.read();
        
        if(ch == '\n') {

          if(command.length() > 1){
                command = command.substring(0, command.length() - 1 );      //исключаем символ переноса строки
          }
          setCommand(command);
          command = "";
          
        }
        else {
            command += ch;
            if(command.length() > 25 ) {
              command = "";
            }
        }
    }      
}


void print_Serial(String str){
      Serial.print(str);
      delay(delaySerialPrint);
}






//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void setCommand(String com){

    /////////////////////////////////////////////////////////////////// Управление питанием "5V-OK"
    control_5V_OK(com);

    /////////////////////////////////////////////////////////////////// Управление питанием "5V-RK"
    control_5V_RK(com);

    /////////////////////////////////////////////////////////////////// Управление питанием усилителей основным каналом управления
    supplyAmpsControl_OK(com);

    /////////////////////////////////////////////////////////////////// Управление питанием усилителей резервным каналом управления
    supplyAmpsControl_RK(com);


    /////////////////////////////////////////////////////////////////// Управление телеметрией основного канала
    printTmByCommand_OK(com);

    /////////////////////////////////////////////////////////////////// Управление телеметрией резервного канала
    printTmByCommand_RK(com);

    ////////////////////////////////////////////////////////////////// Получение телеметрии основного канала в автоматическом режиме
    tm_Auto_OK(com);

    ////////////////////////////////////////////////////////////////// Получение телеметрии резервного канала в автоматическом режиме
    tm_Auto_RK(com);

    /////////////////////////////////////////////////////////////////// Управление аттенюатором основного канала
    att_OK(com);

    /////////////////////////////////////////////////////////////////// Управление аттенюатором резервного канала
    att_RK(com);

    /////////////////////////////////////////////////////////////////// Управление светодиодами, получение версии ПО
    ledControlAndVersion(com);




}




/////////////////////////////////////////////////////////////////// Управление светодиодами, получение версии ПО
void ledControlAndVersion( String coms ){
      if(coms.equals(LED_ON) ){         
          setLedON();
      }      
      if(coms.equals(LED_OFF) ){    
          setLedOFF();                      
      }      
      if(coms.equals(VERSION_GET) ){    
          printVersion();                      
      }
}
void setLedON(){
     digitalWrite(LED_CONTROL, HIGH);
     print_Serial(LED_ON_Good); 
}
void setLedOFF(){
     digitalWrite(LED_CONTROL, LOW);
     print_Serial(LED_OFF_Good); 
}
void printVersion(){
     print_Serial(version); 
}





























/////////////////////////////////////////////////////////////////// Управление питанием "5V-OK"
void control_5V_OK(String com){

    //Включение "5V-OK"
    if( com.equals(OK_5Vs_ON) ){      
        if(is_VKL2_ON() ){                                  // 5V-RK включен?
            print_Serial(OK_5Vs_ON_Error_5V_RK_ON);         // Да -> сообщение об ошибке
        } else {
            set_VKL1_ON();                                  // Нет -> устанавливаем в пульте и 
            print_Serial(OK_5Vs_ON_Good);                   // выводим сообщение
        }
    }      

    //Отключение "5V-OK"
    if( com.equals(OK_5Vs_OFF) ){      
        if(is_VKL2_ON() ){                                  // 5V-RK включен?
            print_Serial(OK_5Vs_OFF_Error_5V_RK_ON);        // Да -> сообщение об ошибке
        } else {
            set_VKL1_OFF();                                  // Нет -> устанавливаем в пульте и 
            print_Serial(OK_5Vs_OFF_Good);                   // выводим сообщение
        }
    }      
    
}

boolean is_VKL1_ON(){
    return states[0];
}

void set_VKL1_ON(){
    digitalWrite(VKL_1, HIGH); 
    digitalWrite(OE_OK, HIGH);       // Высокий уровень регистры в Z-
    states[0] = true;
}

void set_VKL1_OFF(){
    digitalWrite(VKL_1, LOW); 
    states[0] = false;
    isAutoTM_OK = false;
}



/////////////////////////////////////////////////////////////////// Управление питанием "5V-RK"
void control_5V_RK(String com){

    //Включение "5V-RK"
    if( com.equals(RK_5Vs_ON) ){      
        if(is_VKL1_ON() ){                                  // 5V-OK включен?
            print_Serial(RK_5Vs_ON_Error_5V_OK_ON);         // Да -> сообщение об ошибке
        } else {
            set_VKL2_ON();                                  // Нет -> устанавливаем в пульте и 
            print_Serial(RK_5Vs_ON_Good);                   // выводим сообщение
        }
    }      

    //Отключение "5V-RK"
    if( com.equals(RK_5Vs_OFF) ){      
        if(is_VKL1_ON() ){                                  // 5V-OK включен?
            print_Serial(RK_5Vs_OFF_Error_5V_OK_ON);        // Да -> сообщение об ошибке
        } else {
            set_VKL2_OFF();                                  // Нет -> устанавливаем в пульте и 
            print_Serial(RK_5Vs_OFF_Good);                   // выводим сообщение
        }
    }   

}

boolean is_VKL2_ON(){
    return states[1];
}

void set_VKL2_ON(){
    digitalWrite(VKL_2, HIGH);   
    digitalWrite(OE_RK, HIGH);       // Высокий уровень регистры в Z-состоянии 
    states[1] = true;
}

void set_VKL2_OFF(){
    digitalWrite(VKL_2, LOW); 
    states[1] = false;
    isAutoTM_RK  = false;
}




















/////////////////////////////////////////////////////////////////// Управление питанием усилителей основным каналом управления
void supplyAmpsControl_OK( String com ){

    //Включение напряжений «4V_1_1» и «4V_2_1» (основное питание РЧ-тракта)
    if( com.equals(OK_VKL_4V_osn_1_ON) ){      
      
        if(!is_VKL1_ON() ){                                           // 5V-OK выключен?
            print_Serial(OK_VKL_4V_osn_1_ON_Error_5V_OK_OFF);         // Да -> сообщение об ошибке
        } 
        else if(is_VKL_4V_res1() ) {                                  // ВКЛ_4V_рез1 ?
            print_Serial(OK_VKL_4V_osn_1_ON_Error_4V_res_1_ON);       // Да -> сообщение об ошибке
        }
        else if(is_VKL1_ON() && !is_VKL_4V_res1()){                       // 5V-OK включен? и ВКЛ_4V_рез1 отключен?
            set_VKL_4V_osn1_ON();                                     // Да -> устанавливаем в пульте и 
            print_Serial(OK_VKL_4V_osn_1_ON_Good);                    // Выводим сообщение
        }
    }      

    //Отключение напряжений «4V_1_1» и «4V_2_1» (основное питание РЧ-тракта)
    if( com.equals(OK_VKL_4V_osn_1_OFF) ){      
      
        if(!is_VKL1_ON() ){                                           // 5V-OK выключен?
            print_Serial(OK_VKL_4V_osn_1_OFF_Error_5V_OK_OFF);        // Да -> сообщение об ошибке
        } 
        else if(is_VKL_4V_res1() ) {                                  // ВКЛ_4V_рез1 ?
            print_Serial(OK_VKL_4V_osn_1_OFF_Error_4V_res_1_ON);      // Да -> сообщение об ошибке
        }
        else if(is_VKL1_ON() && !is_VKL_4V_res1()){                       // 5V-OK включен? и ВКЛ_4V_рез1 отключен?
            set_VKL_4V_osn1_OFF();                                    // Да -> устанавливаем в пульте и 
            print_Serial(OK_VKL_4V_osn_1_OFF_Good);                   // Выводим сообщение
        }
    }   

    // Включение напряжений «4V_1_2» и «4V_2_2» (резервное питание РЧ-тракта)
    if( com.equals(OK_VKL_4V_res_1_ON) ){      
      
        if(!is_VKL1_ON() ){                                           // 5V-OK выключен?
            print_Serial(OK_VKL_4V_res_1_ON_Error_5V_OK_OFF);        // Да -> сообщение об ошибке
        } 
        else if(is_VKL_4V_osn1() ) {                                  // ВКЛ_4V_осн1 ?
            print_Serial(OK_VKL_4V_res_1_ON_Error_4V_osn_1_ON);       // Да -> сообщение об ошибке
        }
        else if(is_VKL1_ON() && !is_VKL_4V_osn1()){                       // 5V-OK включен? и ВКЛ_4V_осн1 отключен?
            set_VKL_4V_res1_ON();                                     // Да -> устанавливаем в пульте и 
            print_Serial(OK_VKL_4V_res_1_ON_Good);                    // Выводим сообщение
        }
    }   

    // Отключение напряжений «4V_1_2» и «4V_2_2» (резервное питание РЧ-тракта)
    if( com.equals(OK_VKL_4V_res_1_OFF) ){      
      
        if(!is_VKL1_ON() ){                                           // 5V-OK выключен?
            print_Serial(OK_VKL_4V_res_1_OFF_Error_5V_OK_OFF);        // Да -> сообщение об ошибке
        } 
        else if(is_VKL_4V_osn1() ) {                                  // ВКЛ_4V_осн1 ?
            print_Serial(OK_VKL_4V_res_1_OFF_Error_4V_osn_1_ON);       // Да -> сообщение об ошибке
        }
        else if(is_VKL1_ON() && !is_VKL_4V_osn1()){                        // 5V-OK включен? и ВКЛ_4V_осн1 отключен?
            set_VKL_4V_res1_OFF();                                     // Да -> устанавливаем в пульте и 
            print_Serial(OK_VKL_4V_res_1_OFF_Good);                    // Выводим сообщение
        }
    }   

}

boolean is_VKL_4V_osn1(){
    return states[2];
}
void set_VKL_4V_osn1_ON(){
    setRegister_OK( 1 );                    
    states[2] = true;
}
void set_VKL_4V_osn1_OFF(){   
    setRegister_OK( 0 );             
    states[2] = false;

}


boolean is_VKL_4V_res1(){
    return states[3];

}
void set_VKL_4V_res1_ON(){
    setRegister_OK( 2 );                    
    states[3] = true;
}
void set_VKL_4V_res1_OFF(){   
    setRegister_OK( 0 );             
    states[3] = false;
}




/////////////////////////////////////////////////////////////////// Управление питанием усилителей резервным каналом управления
void supplyAmpsControl_RK( String com ){

    //Включение напряжений «4V_1_1» и «4V_2_1» (основное питание РЧ-тракта)
    if( com.equals(RK_VKL_4V_osn_2_ON ) ){      
      
        if(!is_VKL2_ON() ){                                            // 5V-RK выключен?
            print_Serial(RK_VKL_4V_osn_2_ON_Error_5V_RK_OFF );         // Да -> сообщение об ошибке     
        } 
        else if(is_VKL_4V_res2() ) {                                   // ВКЛ_4V_рез2 ?
            print_Serial(RK_VKL_4V_osn_2_ON_Error_4V_res_2_ON );       // Да -> сообщение об ошибке
        }
        else if(is_VKL2_ON() && !is_VKL_4V_res2()){                     // 5V-RK включен? и ВКЛ_4V_рез2 отключен?
            set_VKL_4V_osn2_ON();                                       // Да -> устанавливаем в пульте и 
            print_Serial(RK_VKL_4V_osn_2_ON_Good );                     // Выводим сообщение
        }
    }      

    //Отключение напряжений «4V_1_1» и «4V_2_1» (основное питание РЧ-тракта)
    if( com.equals(RK_VKL_4V_osn_2_OFF  ) ){      
      
        if(!is_VKL2_ON() ){                                           // 5V-RK выключен?
            print_Serial(RK_VKL_4V_osn_2_OFF_Error_5V_RK_OFF  );      // Да -> сообщение об ошибке
        } 
        else if(is_VKL_4V_res2() ) {                                  // ВКЛ_4V_рез2 ?
            print_Serial(RK_VKL_4V_osn_2_OFF_Error_4V_res_2_ON  );    // Да -> сообщение об ошибке
        }
        else if(is_VKL2_ON() && !is_VKL_4V_res2()){                   // 5V-RK включен? и ВКЛ_4V_рез2 отключен?
            set_VKL_4V_osn2_OFF();                                    // Да -> устанавливаем в пульте и 
            print_Serial(RK_VKL_4V_osn_2_OFF_Good );                  // Выводим сообщение
        }
    }   

    // Включение напряжений «4V_1_2» и «4V_2_2» (резервное питание РЧ-тракта)
    if( com.equals(RK_VKL_4V_res_2_ON ) ){      
      
        if(!is_VKL2_ON() ){                                           // 5V-RK выключен?
            print_Serial(RK_VKL_4V_res_2_ON_Error_5V_RK_OFF  );       // Да -> сообщение об ошибке      // Здесь
        } 
        else if(is_VKL_4V_osn2() ) {                                  // ВКЛ_4V_осн2 ?
            print_Serial(RK_VKL_4V_res_2_ON_Error_4V_osn_2_ON );      // Да -> сообщение об ошибке
        }
        else if(is_VKL2_ON() && !is_VKL_4V_osn2()){                   // 5V-RK включен? и ВКЛ_4V_осн2 отключен?
            set_VKL_4V_res2_ON();                                     // Да -> устанавливаем в пульте и 
            print_Serial(RK_VKL_4V_res_2_ON_Good  );                  // Выводим сообщение
        }
    }   

    // Отключение напряжений «4V_1_2» и «4V_2_2» (резервное питание РЧ-тракта)
    if( com.equals(RK_VKL_4V_res_2_OFF ) ){      
      
        if(!is_VKL2_ON() ){                                            // 5V-RK выключен?
            print_Serial(RK_VKL_4V_res_2_OFF_Error_5V_RK_OFF );        // Да -> сообщение об ошибке       Здесь
        } 
        else if(is_VKL_4V_osn2() ) {                                   // ВКЛ_4V_осн2 ?
            print_Serial(RK_VKL_4V_res_2_OFF_Error_4V_osn_2_ON );      // Да -> сообщение об ошибке
        }
        else if(is_VKL2_ON() && !is_VKL_4V_osn2()){                        // 5V-OK включен? и ВКЛ_4V_осн1 отключен?
            set_VKL_4V_res2_OFF();                                     // Да -> устанавливаем в пульте и 
            print_Serial(RK_VKL_4V_res_2_OFF_Good );                    // Выводим сообщение
        }
    }   

}



boolean is_VKL_4V_osn2(){
    return states[4];
}
void set_VKL_4V_osn2_ON(){
    setRegister_RK( 1 );                    
    states[4] = true;
}
void set_VKL_4V_osn2_OFF(){   
    setRegister_RK( 0 );              
    states[4] = false;

}


boolean is_VKL_4V_res2(){
    return states[5];

}
void set_VKL_4V_res2_ON(){
    setRegister_RK( 2 );                    
    states[5] = true;
}
void set_VKL_4V_res2_OFF(){   
    setRegister_RK( 0 );               
    states[5] = false;
}




/////////////////////////////////////////////////////////////////////////////////////// Получение телеметрии основного канала в автоматическом режиме
void tm_Auto_OK(String coms ){
      
      if(coms.equals(OK_TM_AutoON  ) ){    
          if(is_VKL1_ON() ){                                    // 5V-OK включено ?                               
              set_tm_Auto_Ok_ON();                                 // Да
              print_Serial(OK_TM_AutoON_Good );
          }else{                                                // Нет
              print_Serial(OK_TM_AutoON_Error_5V_OK_OFF   );         
          }      
      } 

      if(coms.equals(OK_TM_AutoOFF    ) ){    
          if(is_VKL1_ON() ){                                    // 5V-OK включено ?                               
              set_tm_Auto_Ok_OFF();                                // Да
              print_Serial(OK_TM_AutoOFF_Good   );
          }else{                                                // Нет
              print_Serial(OK_TM_AutoOFF_Error_5V_OK_OFF  );         
          }      
      } 
}

void set_tm_Auto_Ok_ON(){
    isAutoTM_OK = true;
}
void set_tm_Auto_Ok_OFF(){
    isAutoTM_OK = false;    
}


/////////////////////////////////////////////////////////////////////////////////////// Получение телеметрии резервного канала в автоматическом режиме
void tm_Auto_RK(String coms ){
      
      if(coms.equals(RK_TM_AutoON  ) ){    
          if(is_VKL2_ON() ){                                    // 5V-RK включено ?                               
              set_tm_Auto_Rk_ON();                                 // Да
              print_Serial(RK_TM_AutoON_Good );
          }else{                                                // Нет
              print_Serial(RK_TM_AutoON_Error_5V_RK_OFF     );         
          }      
      } 

      if(coms.equals(RK_TM_AutoOFF    ) ){    
          if(is_VKL2_ON() ){                                    // 5V-RK включено ?                               
              set_tm_Auto_Rk_OFF();                                // Да
              print_Serial(RK_TM_AutoOFF_Good   );
          }else{                                                // Нет
              print_Serial(RK_TM_AutoOFF_Error_5V_RK_OFF    );         
          }      
      } 
}

void set_tm_Auto_Rk_ON(){
    isAutoTM_RK = true;
}
void set_tm_Auto_Rk_OFF(){
    isAutoTM_RK = false;    
}


//////////////////////////////////////////////////////////////////////////////////////// метод для управления аттенюатором основного канала
void att_OK(String coms ){

  boolean isAttOK = OK_Att.equals( coms.substring(0, OK_Att.length() ) );
  if( isAttOK ) {

    if( is_VKL1_ON()  ){
 
          if( coms.equals(OK_Att_15_5_dB  ) ) {
                setSPI_OK(31);
          }
          if( coms.equals(OK_Att_15_0_dB  ) ) {
                setSPI_OK(30);
          }
          if( coms.equals(OK_Att_14_5_dB  ) ) {
                setSPI_OK(29);
          }          
          if( coms.equals(OK_Att_14_0_dB  ) ) {
                setSPI_OK(28);
          }

          //////////////////////////////////////////////////////////////////////////////////////
          if( coms.equals(OK_Att_13_5_dB  ) ) {
                setSPI_OK(27);
          }         
          if( coms.equals(OK_Att_13_0_dB  ) ) {
                setSPI_OK(26);            
          }
          if( coms.equals(OK_Att_12_5_dB  ) ) {
                setSPI_OK(25);
          }         
          if( coms.equals(OK_Att_12_0_dB  ) ) {
                setSPI_OK(24);
          }

          //////////////////////////////////////////////////////////////////////////////////////          
          if( coms.equals(OK_Att_11_5_dB  ) ) {
                setSPI_OK(23);
          }         
          if( coms.equals(OK_Att_11_0_dB  ) ) {
                setSPI_OK(22);
          }
          if( coms.equals(OK_Att_10_5_dB  ) ) {
                setSPI_OK(21);
          }         
          if( coms.equals(OK_Att_10_0_dB  ) ) {
                setSPI_OK(20);
          }

          //////////////////////////////////////////////////////////////////////////////////////
          if( coms.equals(OK_Att_9_5_dB  ) ) {
                setSPI_OK(19);
          }         
          if( coms.equals(OK_Att_9_0_dB  ) ) {
                setSPI_OK(18);
          }
          if( coms.equals(OK_Att_8_5_dB  ) ) {
                setSPI_OK(17);
          }         
          if( coms.equals(OK_Att_8_0_dB  ) ) {
                setSPI_OK(16);
          }

          //////////////////////////////////////////////////////////////////////////////////////       
          if( coms.equals(OK_Att_7_5_dB  ) ) {
                setSPI_OK(15);
          }         
          if( coms.equals( OK_Att_7_0_dB ) ) {
                setSPI_OK(14);
          }
          if( coms.equals(OK_Att_6_5_dB ) ) {
                setSPI_OK(13);
          }         
          if( coms.equals(OK_Att_6_0_dB) ) {
                setSPI_OK(12);
          }
          
          ////////////////////////////////////////////////////////////////////////////////////// 
          if( coms.equals(OK_Att_5_5_dB  ) ) {
                setSPI_OK(11);
          }         
          if( coms.equals(OK_Att_5_0_dB  ) ) {
                setSPI_OK(10);
          }
          if( coms.equals(OK_Att_4_5_dB  ) ) {
                setSPI_OK(9);
          }         
          if( coms.equals(OK_Att_4_0_dB  ) ) {
                setSPI_OK(8);
          }
          
          ////////////////////////////////////////////////////////////////////////////////////// 
          if( coms.equals(OK_Att_3_5_dB  ) ) {
                setSPI_OK(7);
          }         
          if( coms.equals(OK_Att_3_0_dB  ) ) {
                setSPI_OK(6);
          }
          if( coms.equals(OK_Att_2_5_dB  ) ) {
                setSPI_OK(5);
          }         
          if( coms.equals(OK_Att_2_0_dB  ) ) {
                setSPI_OK(4);
          }

          //////////////////////////////////////////////////////////////////////////////////////           
          if( coms.equals(OK_Att_1_5_dB  ) ) {
                setSPI_OK(3);
          }         
          if( coms.equals(OK_Att_1_0_dB  ) ) {
                setSPI_OK(2);
          }        
          if( coms.equals(OK_Att_0_5_dB  ) ) {
                setSPI_OK(1);
          }         
          if( coms.equals(OK_Att_0_0_dB  ) ) {
                setSPI_OK(0);
          }

          print_Serial(coms + good);    
          
    }  else {
          print_Serial(OK_Att_Error_5V_OK_OFF );                  
    } 
  }
}



//////////////////////////////////////////////////////////////////////////////////////// метод для управления аттенюатором резервного канала
void att_RK(String coms ){


  boolean isAttRK = RK_Att.equals( coms.substring(0, RK_Att.length() ) );
  if( isAttRK ) {

    if( is_VKL2_ON() ){
  
          if( coms.equals(RK_Att_15_5_dB  ) ) {
                setSPI_RK(31);
          }
          if( coms.equals(RK_Att_15_0_dB  ) ) {
                setSPI_RK(30);
          }
          if( coms.equals(RK_Att_14_5_dB  ) ) {
                setSPI_RK(29);
          }          
          if( coms.equals(RK_Att_14_0_dB  ) ) {
                setSPI_RK(28);
          }

          //////////////////////////////////////////////////////////////////////////////////////
          if( coms.equals(RK_Att_13_5_dB  ) ) {
                setSPI_RK(27);
          }         
          if( coms.equals(RK_Att_13_0_dB  ) ) {
                setSPI_RK(26);            
          }
          if( coms.equals(RK_Att_12_5_dB  ) ) {
                setSPI_RK(25);
          }         
          if( coms.equals(RK_Att_12_0_dB  ) ) {
                setSPI_RK(24);
          }

          //////////////////////////////////////////////////////////////////////////////////////          
          if( coms.equals(RK_Att_11_5_dB  ) ) {
                setSPI_RK(23);
          }         
          if( coms.equals(RK_Att_11_0_dB  ) ) {
                setSPI_RK(22);
          }
          if( coms.equals(RK_Att_10_5_dB  ) ) {
                setSPI_RK(21);
          }         
          if( coms.equals(RK_Att_10_0_dB  ) ) {
                setSPI_RK(20);
          }

          //////////////////////////////////////////////////////////////////////////////////////
          if( coms.equals(RK_Att_9_5_dB  ) ) {
                setSPI_RK(19);
          }         
          if( coms.equals(RK_Att_9_0_dB  ) ) {
                setSPI_RK(18);
          }
          if( coms.equals(RK_Att_8_5_dB  ) ) {
                setSPI_RK(17);
          }         
          if( coms.equals(RK_Att_8_0_dB  ) ) {
                setSPI_RK(16);
          }

          //////////////////////////////////////////////////////////////////////////////////////       
          if( coms.equals(RK_Att_7_5_dB  ) ) {
                setSPI_RK(15);
          }         
          if( coms.equals( RK_Att_7_0_dB ) ) {
                setSPI_RK(14);
          }
          if( coms.equals(RK_Att_6_5_dB ) ) {
                setSPI_RK(13);
          }         
          if( coms.equals(RK_Att_6_0_dB) ) {
                setSPI_RK(12);
          }
          
          ////////////////////////////////////////////////////////////////////////////////////// 
          if( coms.equals(RK_Att_5_5_dB  ) ) {
                setSPI_RK(11);
          }         
          if( coms.equals(RK_Att_5_0_dB  ) ) {
                setSPI_RK(10);
          }
          if( coms.equals(RK_Att_4_5_dB  ) ) {
                setSPI_RK(9);
          }         
          if( coms.equals(RK_Att_4_0_dB  ) ) {
                setSPI_RK(8);
          }
          
          ////////////////////////////////////////////////////////////////////////////////////// 
          if( coms.equals(RK_Att_3_5_dB  ) ) {
                setSPI_RK(7);
          }         
          if( coms.equals(RK_Att_3_0_dB  ) ) {
                setSPI_RK(6);
          }
          if( coms.equals(RK_Att_2_5_dB  ) ) {
                setSPI_RK(5);
          }         
          if( coms.equals(RK_Att_2_0_dB  ) ) {
                setSPI_RK(4);
          }

          //////////////////////////////////////////////////////////////////////////////////////           
          if( coms.equals(RK_Att_1_5_dB  ) ) {
                setSPI_RK(3);
          }         
          if( coms.equals(RK_Att_1_0_dB  ) ) {
                setSPI_RK(2);
          }        
          if( coms.equals(RK_Att_0_5_dB  ) ) {
                setSPI_RK(1);
          }         
          if( coms.equals(RK_Att_0_0_dB  ) ) {
                setSPI_RK(0);
          }

          print_Serial(coms + good);      
          
    }  else {
          print_Serial(RK_Att_Error_5V_RK_OFF );                  
    } 
  
  }
  
}









void setSPI_OK(int num){
    digitalWrite(EN_SPI_OK, LOW);
    
    digitalWrite(LE, LOW);        
    SPI.transfer( num );    
    digitalWrite(LE, HIGH);
    
    //delay(time_delay);
    //digitalWrite(LE, LOW);  


    digitalWrite(EN_SPI_OK, HIGH);  
    //Serial.print( num  );   
}






void setSPI_RK(int num){
    digitalWrite(EN_SPI_RK, LOW);
  
    digitalWrite(LE, LOW);        
    SPI.transfer( num );    
    digitalWrite(LE, HIGH);

    //delay(time_delay);
    //digitalWrite(LE, LOW);   


    digitalWrite(EN_SPI_RK, HIGH);     
    //Serial.print( num  );   
}










//////////////////////////////////////////////////////////////////////////////////////////////////////////////
void setRegisterAndPrintTM_OK(String coms, String expectedCommand,  int regVal_Res1_Off_Osns1_Off,
                                                                    int regVal_Res1_Off_Osns1_ON, 
                                                                    int regVal_Res1_ON_Osns1_OFF ){
    if( coms.equals(expectedCommand) )  {
          if(is_VKL1_ON()){
                if( !is_VKL_4V_res1() && !is_VKL_4V_osn1() ){
                    setRegister_OK(regVal_Res1_Off_Osns1_Off);                                
                    print_TM_OK(coms);
                }
                if( !is_VKL_4V_res1() && is_VKL_4V_osn1() ){
                    setRegister_OK(regVal_Res1_Off_Osns1_ON);                                
                    print_TM_OK(coms);
                }
                if( is_VKL_4V_res1() && !is_VKL_4V_osn1() ){
                    setRegister_OK(regVal_Res1_ON_Osns1_OFF);                               
                    print_TM_OK(coms);
                }          
          } else{
                print_Serial(OK_TM_Error_5V_OK_OFF);
          }
    }
}


void setRegisterAndPrintTemp_RK(String coms, String expectedCommand,  int regVal_Res1_Off_Osns1_Off,
                                                                      int regVal_Res1_Off_Osns1_ON, 
                                                                      int regVal_Res1_ON_Osns1_OFF ){
    if( coms.equals(expectedCommand) )  {
          if(is_VKL2_ON()){
                if( !is_VKL_4V_res2() && !is_VKL_4V_osn2() ){
                    setRegister_RK(regVal_Res1_Off_Osns1_Off);                                
                    print_TM_Temp_RK(coms);
                }
                if( !is_VKL_4V_res2() && is_VKL_4V_osn2() ){
                    setRegister_RK(regVal_Res1_Off_Osns1_ON);                                
                    print_TM_Temp_RK(coms);
                }
                if( is_VKL_4V_res2() && !is_VKL_4V_osn2() ){
                    setRegister_RK(regVal_Res1_ON_Osns1_OFF);                               
                    print_TM_Temp_RK(coms);
                }          
          } else{
                print_Serial(RK_TM_Error_5V_RK_OFF);
          }
    }
}


void setRegisterAndPrintTM_RK(String coms, String expectedCommand,  int regVal_Res1_Off_Osns1_Off,
                                                                    int regVal_Res1_Off_Osns1_ON, 
                                                                    int regVal_Res1_ON_Osns1_OFF ){
    if( coms.equals(expectedCommand) )  {
          if(is_VKL2_ON()){
                if( !is_VKL_4V_res2() && !is_VKL_4V_osn2() ){
                    setRegister_RK(regVal_Res1_Off_Osns1_Off);                                
                    print_TM_RK(coms);
                }
                if( !is_VKL_4V_res2() && is_VKL_4V_osn2() ){
                    setRegister_RK(regVal_Res1_Off_Osns1_ON);                                
                    print_TM_RK(coms);
                }
                if( is_VKL_4V_res2() && !is_VKL_4V_osn2() ){
                    setRegister_RK(regVal_Res1_ON_Osns1_OFF);                               
                    print_TM_RK(coms);
                }          
          } else{
                print_Serial(RK_TM_Error_5V_RK_OFF);     
          }
    }
}



void setRegisterAndPrintTemp_OK(String coms, String expectedCommand,  int regVal_Res1_Off_Osns1_Off,
                                                                      int regVal_Res1_Off_Osns1_ON, 
                                                                      int regVal_Res1_ON_Osns1_OFF ){
    if( coms.equals(expectedCommand) )  {
          if(is_VKL1_ON()){
                if( !is_VKL_4V_res1() && !is_VKL_4V_osn1() ){
                    setRegister_OK(regVal_Res1_Off_Osns1_Off);                                
                    print_TM_Temp_OK(coms);
                }
                if( !is_VKL_4V_res1() && is_VKL_4V_osn1() ){
                    setRegister_OK(regVal_Res1_Off_Osns1_ON);                                
                    print_TM_Temp_OK(coms);
                }
                if( is_VKL_4V_res1() && !is_VKL_4V_osn1() ){
                    setRegister_OK(regVal_Res1_ON_Osns1_OFF);                               
                    print_TM_Temp_OK(coms);
                }          
          } else{
                print_Serial(OK_TM_Error_5V_OK_OFF);
          }
    }
}








void printTmByCommand_RK(String coms){
  boolean isTm_RK = RK_TM.equals( coms.substring(0, RK_TM.length() ) );
  if( isTm_RK ) {
    
      setRegisterAndPrintTM_RK(coms, RK_TM_DM0, 0, 1, 2);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM1, 128, 129, 130);    
      setRegisterAndPrintTM_RK(coms, RK_TM_DM2, 64, 65, 66);     
      setRegisterAndPrintTM_RK(coms, RK_TM_DM3, 192, 193, 194);

      setRegisterAndPrintTM_RK(coms, RK_TM_DM4, 32, 33, 34);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM5, 160, 161, 162);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM6, 96, 97, 98);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM7, 224, 225, 226);      

      setRegisterAndPrintTM_RK(coms, RK_TM_DM8, 16, 17, 18);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM9, 144, 145, 146);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM10, 80, 81, 82);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM11, 208, 209, 210);

      setRegisterAndPrintTM_RK(coms, RK_TM_DM12, 48, 49, 50);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM13, 176, 177, 178);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM14, 112, 113, 114);
      setRegisterAndPrintTM_RK(coms, RK_TM_DM15, 240, 241, 242);

      setRegisterAndPrintTM_RK(coms, RK_TM_5Vout2  , 8, 9, 10);
      setRegisterAndPrintTM_RK(coms, RK_TM_4V_2_2  , 136, 137, 138);
      setRegisterAndPrintTM_RK(coms, RK_TM_4V_1_2  , 72, 73, 74);
      setRegisterAndPrintTM_RK(coms, RK_TM_4V_2_1  , 200, 201, 202);
      setRegisterAndPrintTM_RK(coms, RK_TM_4V_1_1  , 40, 41, 42);      
      
      setRegisterAndPrintTM_RK(coms, RK_TM_4V_2out  , 168, 169, 170);
      setRegisterAndPrintTM_RK(coms, RK_TM_4V_1out  , 104, 105, 106);
      setRegisterAndPrintTM_RK(coms, RK_TM_GND  , 232, 233, 234);
      setRegisterAndPrintTM_RK(coms, RK_TM_Neg5Vout2  , 24, 25, 26);
      setRegisterAndPrintTM_RK(coms, RK_TM_TEMP2  , 248, 249, 250);

      setRegisterAndPrintTemp_RK(coms, RK_TM_TEMP2_C  , 248, 249, 250); 
      delay(delaySerialPrint); 
  }
}
                                                              
void printTmByCommand_OK(String coms){
    boolean isTm_OK = OK_TM .equals( coms.substring(0, OK_TM.length() ) );
    if( isTm_OK ) {

      setRegisterAndPrintTM_OK(coms, OK_TM_DM0, 0, 1, 2);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM1, 128, 129, 130);    
      setRegisterAndPrintTM_OK(coms, OK_TM_DM2, 64, 65, 66);     
      setRegisterAndPrintTM_OK(coms, OK_TM_DM3, 192, 193, 194);

      setRegisterAndPrintTM_OK(coms, OK_TM_DM4, 32, 33, 34);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM5, 160, 161, 162);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM6, 96, 97, 98);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM7, 224, 225, 226);      

      setRegisterAndPrintTM_OK(coms, OK_TM_DM8, 16, 17, 18);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM9, 144, 145, 146);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM10, 80, 81, 82);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM11, 208, 209, 210);

      setRegisterAndPrintTM_OK(coms, OK_TM_DM12, 48, 49, 50);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM13, 176, 177, 178);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM14, 112, 113, 114);
      setRegisterAndPrintTM_OK(coms, OK_TM_DM15, 240, 241, 242);

      setRegisterAndPrintTM_OK(coms, OK_TM_5Vout1, 8, 9, 10);
      setRegisterAndPrintTM_OK(coms, OK_TM_4V_2_2, 136, 137, 138);
      setRegisterAndPrintTM_OK(coms, OK_TM_4V_1_2, 72, 73, 74);
      setRegisterAndPrintTM_OK(coms, OK_TM_4V_2_1, 200, 201, 202);
      setRegisterAndPrintTM_OK(coms, OK_TM_4V_1_1, 40, 41, 42);      
      
      setRegisterAndPrintTM_OK(coms, OK_TM_4V_2out, 168, 169, 170);
      setRegisterAndPrintTM_OK(coms, OK_TM_4V_1out, 104, 105, 106);
      setRegisterAndPrintTM_OK(coms, OK_TM_GND, 232, 233, 234);
      setRegisterAndPrintTM_OK(coms, OK_TM_Neg5Vout1, 24, 25, 26);
      setRegisterAndPrintTM_OK(coms, OK_TM_TEMP1, 248, 249, 250);

      setRegisterAndPrintTemp_OK(coms, OK_TM_TEMP1_C, 248, 249, 250);
      delay(delaySerialPrint);
    }
}
                                                              

////////////////////////////////////////////////////////////////////////////////////////////////
void print_TM_OK(String com){
      Serial.print(com);  
      int valFromADC = analogRead(ADC_OK);
      double valueOK  = (3.3 * valFromADC / 1023) ;  
      Serial.print( valueOK , 3 );                    // 3-знака после запятой
      Serial.print(";");  
      delay(delaySerialPrint);      
}

void print_TM_RK(String com){
      Serial.print(com);  
      int valFromADC = analogRead(ADC_RK);
      double valueRK  = (3.3 * valFromADC / 1023) ;  
      Serial.print( valueRK , 3 );                    // 3-знака после запятой
      Serial.print(";");  
      delay(delaySerialPrint);      
}



void print_TM_Temp_OK(String com){
      Serial.print(com);  
      int valFromADC = analogRead(ADC_OK);
      double tempOK  =  (valFromADC * 2/ alpha ) -273  ;  
      Serial.print( 25.00 , 2 );                    // 2-знака после запятой
      Serial.print(";");  
      delay(delaySerialPrint);      
}


void print_TM_Temp_RK(String com){
      Serial.print(com);  
      int valFromADC = analogRead(ADC_RK);
      double tempRK  =  (valFromADC * 2/ alpha ) -273  ;  
      Serial.print( 25.00 , 2 );                    // 2-знака после запятой
      Serial.print(";");  
      delay(delaySerialPrint);      
}





// Установка сдвигового регистра
void setRegister_OK(int numberOfDisplay){
    digitalWrite(OE_OK, LOW);
    digitalWrite(ST_CP_OK, LOW);
    shiftOut(DS_OK, SH_CP_OK, MSBFIRST, numberOfDisplay); 
    digitalWrite(ST_CP_OK, HIGH);
    
    digitalWrite(OE_OK, LOW);
    
    delay(timer_RegisterOK);
}


void setRegister_RK(int numberOfDisplay){
    digitalWrite(OE_RK, LOW);
    digitalWrite(ST_CP_RK, LOW);
    shiftOut(DS_RK, SH_CP_RK, MSBFIRST, numberOfDisplay); 
    digitalWrite(ST_CP_RK, HIGH);

    digitalWrite(OE_RK, LOW);
        
    delay(timer_RegisterRK);
}
