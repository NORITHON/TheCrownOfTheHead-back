# The Crown Of The Head 팀의 Moo:re 서비스

## 👋 소개

   
![moore1](https://user-images.githubusercontent.com/49269218/215564794-31d79f41-d213-40f7-b4fb-4fb13a3a6dee.png)


   
__"최상위 클래스의 디자이너만 살아남는 패션 업계의 고질적인 문제를 어떻게 해결할 수 있을까?"__ 라는 고민에서 시작된 우리의 플랫폼 __👿Moo:re__ 를 소개합니다.

**👿Moo:re**는 make ordinary opportunity로 우리는 ‘평범한 기회를 주는 사람’입니다.


독점 계약 시스템 아래에 있는 최상위권 디자이너 외의 평범한 middle class 디자이너들에게 제품을 출시할 기회, 소비자에게 노출 될 기회를 제공하는 것입니다. 





**Moo:re**의 주 고객은 두 부류입니다.


1. ✍디자이너 : 자신의 디자인 샘플을 마음 껏 게재할 수 있는 공간을 제공합니다. 


2. 😀소비자 : middle class 디자이너들의 독창적이고 개성있는 디자인 샘플을 구경하고, 좋아요 누르기, 크라우드 펀딩 참여를 할 수 있습니다.






이 두 고객의 가운데에 있는 생산업체는 💕좋아요 수가 많은 디자인 샘플을 선택해 원자재, 인건비, 펀딩 모집 인원을 선택해 펀딩 상품으로 등록할 수 있습니다.


펀딩 진행중인 상품, 모집이 완료된 상품 내역을 확인하고 주문을 처리할 수 있습니다. 



## 👫 팀원 소개

|<img src="./image/profile.jpeg" width="80">|<img src="https://github.com/ChaewonLee21.png" width="80">|<img src="https://github.com/ohinhyuk.png" width="80">|<img src="https://github.com/yujin9747.png" width="80">|<img src="https://github.com/woals00.png" width="80">|
|:---:|:---:|:---:|:---:|:---:|
|[](https://github.com/ImInnocent)|[](https://github.com/ChaewonLee21)|[](https://github.com/ohinhyuk)|[](https://github.com/yujin9747)|[](https://github.com/woals00)|
|정수연|이채원|오인혁|장유진|정재민
|기획자|디자이너|프론트엔드|백엔드|백엔드


## 🛠 개발 스택

### Front   
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black"> <img src="https://img.shields.io/badge/Mui-0C2340?style=for-the-badge&logo=MUI&logoColor=#FFFFFF"> <img src="https://img.shields.io/badge/styled-components-DB7093?style=for-the-badge&logo=styled-components&logoColor=#000000"> <img src="https://img.shields.io/badge/axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white">

### Back   

<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white"> <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"> <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white">


## 🎢 개발 과정
0. 백, 프론트 역할 분담 및 개발 시작


1. ERD 설계, table 설계


2. Entity 작성 -> package name : domain


3. Repository 작성 -> package name : repository


4. Service 작성 -> package name : service


5. Controller 작성 -> package name : controller


6. postman을 사용해 API 테스트


7. 프론트 API 연결


8. 디버깅 및 테스트



## 💪 기능 구현 내용
- 디자이너로 회원가입
- 소비자로 회원가입
- 디자이너로 로그인
- 소비자로 로그인
- 샘플 게재(이름, 설명, 사진) : 디자이너 권한
- 샘플 list 조회
- 샘플에 좋아요 및 취소 : 소비자 권한
- 좋아요 기준 내림차순 샘플 정렬 : 생산자의 관리 페이지
- 샘플 선택 및 펀딩 상품 등록(원자재, 인건비, 펀딩 모집 인원) : 관리자 권한
- 펀딩 참여(주소, 전화번호, 수량) : 소비자 권한
- 주문 내역 조회 : 관리자 페이지 -> 펀딩 모집중(waiting), 모집 완료 및 제작 시작(approved)로 분류

## 🖼 기능 추가 설명 (이미지)

![moorefront](https://user-images.githubusercontent.com/49269218/215571600-9d9c89fb-77d9-4a95-9729-b2e75dfc8a4c.jpg)

![mooretest](https://user-images.githubusercontent.com/49269218/215569379-cf5c327f-a80e-48e2-9e04-31a758d269c3.jpg)

![moore3](https://user-images.githubusercontent.com/49269218/215569863-31705fe5-e2db-418f-b4cd-6aa2c8960077.jpg)

![moore4](https://user-images.githubusercontent.com/49269218/215569859-0f077065-a1bd-4757-9be7-98a6d4d2252c.jpg)

![moore5](https://user-images.githubusercontent.com/49269218/215569855-404dda62-566a-4b4b-bf2c-a3f29e557688.jpg)

![moore6](https://user-images.githubusercontent.com/49269218/215569851-2ae4e795-9028-4862-8659-ba85dddbe21f.jpg)

![moore7](https://user-images.githubusercontent.com/49269218/215569849-bd80acf4-01fd-4fa7-94a9-774f5c6743da.jpg)

![moore8](https://user-images.githubusercontent.com/49269218/215569847-c950db73-a3c8-4d83-a328-eab4df60da2e.jpg)

![moore9](https://user-images.githubusercontent.com/49269218/215569837-5b714e1e-9fb7-4ca4-810f-8303b1011566.jpg)
