# 💳 계좌 관리 서비스
핀테크 서비스의 계좌 관리 서비스입니다. </br>
동시성 문제에 대해 깊이있는 공부를 하기 위한 프로젝트 입니다.

</br>

## 프로젝트 기능 및 설계
- 회원가입 기능
  - 생성
    - 사용자는 회원가입을 할 수 있다.
    - 사용자는 가입 시 계좌가 없는 상태로 가입된다.
    - 사용자의 아이디는 unique 해야 한다.
  - 삭제
    - 사용자는 회원 탈퇴를 할 수 있다.
    - 사용자의 정보는 회원 탈퇴 시에 즉시 삭제된다.

</br>

- 로그인 기능
  - 사용자는 로그인을 할 수 있다.
  - 로그인 시 회원가입할 때 입력한 아이디와 패스워드가 일치해야 한다.

</br>

- 로그인/로그아웃에 따른 계좌 접근 허가
  - 사용자는 로그인하면 계좌 서비스에 접근할 수 있다.
  - 사용자는 로그아웃하면 계좌 서비스에 접근할 수 없다.

</br>

- 계좌 관리 (생성/삭제/금액 인출/금액 입금)
  - 생성
    - 사용자는 로그인하면 계좌를 생성할 수 있다.
    - 계좌 전용 비밀번호를 4자리의 숫자로 입력받는다.
    - 계좌를 생성하면 계좌는 IN_USE 상태로 생성된다.
    - 계좌 번호는 은행마다 생성하는 방법이 다르기 때문에, 
      프로젝트에서는 14자리의 랜덤 한 번호를 생성한다.
    - 계좌가 생성된 시간이 저장된다.
    - 사용자가 없는 경우 생성할 수 없다.
    - 한 사람당 계좌 생성 한도는 5개로 제한한다.
  - 삭제
    - 계좌를 삭제하면 해당 계좌는 UNREGISTERED 상태로 변경된다.
    - UNREGISTERED 상태의 계좌는 조회 서비스만 이용할 수 있다.
    - UNREGISTERED 상태로 변경되는 시점에 시간이 저장된다.
    - 변경된 시점으로부터 30일째 되는 시점에 삭제된다.
  - 금액 인출
    - 인출 금액은 사용자의 현재 계좌 잔액보다 클 수 없다.
  - 금액 입금
    - 입금 금액은 0원보다 작을 수 없다.

</br>

- 계좌 검색 기능
  - 사용자의 아이디로 생성한 계좌 목록을 조회할 수 있다.

</br>

- 송금 기능 및 송금 이력 조회
  - IN_USE 상태의 계좌만 송금 서비스를 사용할 수 있다.
  - 송금
    - 사용자가 송금하려는 금액은 0보다 작을 수 없다.
    - 사용자가 송금하려는 금액은 현재 계좌 잔액보다 클 수 없다.
    - 사용자의 계좌에서 금액이 인출되고 인출된 금액만큼 해당 계좌에 금액이 입금된다.
  - 송금 이력 조회
    - 사용자는 계좌를 선택해서 송금 이력을 확인할 수 있다.
    - 송금 이력은 최신순으로 기본 정렬되며, 기간을 설정해서 조회할 수도 있다.
    - 송금 실패 시 실패한 내역을 확인할 수 있다.

</br>

## 🗒 ERD
![ERD](doc/img/erd.png)

</br>

## 📝 Trouble Shooting
[트러블 슈팅 섹션 가기](doc/TROUBLE_SHOOTING.md)

</br>

### 🧰 Tech Stack
<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/OAuth2.0-5D83AC?style=for-the-badge&logo=auth0&logoColor=white">
</div>
