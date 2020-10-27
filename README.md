# Katalon-Web-Automated-Tests
運用Katalon實作網頁自動化測試<br>
主要使用groovy開發(原文件上寫Java是錯的，正確之使用工具為groovy及Katalon) <br>
此為實習時的團隊作品(2人)<br>
<br>
<br>

## 開發平台
Windows10<br>
<br>
<br>

## 開發環境
Katalon<br>
https://www.katalon.com/<br>
<br>
<br>

## 檔案說明
* Script

  放置各test case的腳本<br>

<br>

* Object Repository

  存放test case所需的網頁元素<br>

<br>

* Report

  內有部分測試結果<br>

<br>

* Test Suites

  內有部分測試順序之腳本<br>

<br>
<br>

## 測試網頁說明

* AIC : 包含BMC基本功能之網頁

<br>

* ARMOR : 用於遠端控制多台rack及server的網頁，結合BMC，可達成許多功能，包含燒錄BIOS版本、使用DHCP等等

<br>

* BMC : 用於遠端控制單台server的網頁

<br>

* TOAST : 用於遠端燒錄多台server的網頁

<br>
<br>

## 功能

* AIC

  * AIC_button_test
  
  * AIC_server_test

<br>

* ARMOR

  * practice

  * Allgroup :
  
    針對所有群組操作的功能進行測試

  * AllRack
  
    針對添加及刪除rack等功能進行測試<br>
    包含add stand-alone rack、delete rack、enter & leave maintain mode、modify rack、network time sync、scan等

  * group_rack
  
    針對所有操作群組rack的功能進行測試<br>
    包含open & close all LED、CPNode all functions test、JBNode all functions test、inner modify等

  * single_rack
  
    針對所有操作單一rack的功能進行測試<br>
    包含open & close all LED、CPNode all functions test、JBNode all functions test、RackBP all functions test、RMCtest、inner modify等
  
  * Configuration
  
    針對ARMOR上的設定進行測試<br>
    包含DHCP、Notification、Troubleshooting、Firmware、Service Management、Backup and Restore Management、Language、About等等
  
  * Dashboard
  
    針對ARMOR上的Dashboard進行測試
  
  * biosUpdate
  
    針對CPnode是否能成功燒錄BIOS進行測試
  
  * bmcUpdate
  
    針對CPnode是否能成功燒錄BMC進行測試

  * CreateUser
  
    針對創建User功能進行測試
  
  * openLED
  
    開啟所有LED燈
  
  * turnOffLED
  
    關閉所有LED燈

  
<br>

* BMC

  * NFS Test
  
    測試NFS server連接功能是否正常

  * NTP Test
  
    自行在centos7系統架設NTP server<br>
    藉此測試NTP server連接功能是否正常

  * IPMITest7.9
  
    測試BMC網頁上所有按鈕是否正常
    
  * bmcUpdate
  
    測試BMC版本更新功能是否正常

  * PowerCtl
  
    針對電源開關按鈕進行測試

<br>

* TOAST

  * burnin
  
    測試燒錄之設定、群組功能及是否能正常燒錄
  
  <br>

<br>

## 使用方法
將所有檔案放進同個目錄<br>
使用Katalon開啟後<br>
即可選擇Test Cases去做使用<br>
<br>
<br>

