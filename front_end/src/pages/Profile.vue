<template>
  <q-page class="q-pa-sm">
    <div class="row q-col-gutter-sm">
      <div class="col-lg-8 col-md-8 col-xs-12 col-sm-12">
        <q-card class="card-bg text-white">
          <q-card-section class="text-h6 ">
            <div class="text-h6">정보 수정</div>
            <div class="text-subtitle2">Complete your profile</div>
          </q-card-section>
          <q-card-section class="q-pa-sm">
            <q-list class="row">
              <q-item class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <q-item-section side>
                  <q-avatar size="100px">
                    <img src="https://mblogthumb-phinf.pstatic.net/MjAxOTEwMjlfNDUg/MDAxNTcyMzI5NDcwNjIz.aW2F-SaHTjtOHNUlRixK7I_scEWzQDe7k-JHLkxj9_wg.fKoqWcVf8Y-vVCKGpIqUCy--2rC8Na4pHoGawaOwmVcg.PNG.moonkuki/SE-c0ad31f7-b153-4905-9f10-9d81b853e1e6.png?type=w800">
                  </q-avatar>
                </q-item-section>
                <q-item-section>
                  <q-btn label="Add Photo" class="text-capitalize" rounded color="info" style="max-width: 120px"></q-btn>
                </q-item-section>
              </q-item>

              <q-item class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <q-item-section>
                  <q-input dark color="white" dense v-model="user_details.user_name" label="User Name"/>
                </q-item-section>
              </q-item>
              <q-item class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <q-item-section>
                  <q-input dark color="white" dense v-model="user_details.email" label="Email Address"/>
                </q-item-section>
              </q-item>

              <q-item class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <q-item-section>
                  <q-input dark color="white" autogrow dense v-model="user_details.address" label="Address"/>
                </q-item-section>
              </q-item>
              <q-item class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <q-item-section>
                  <q-input dark color="white" type="textarea" dense v-model="user_details.about" label="About"/>
                </q-item-section>
              </q-item>
            </q-list>
          </q-card-section>
          <q-card-actions align="right">
            <q-btn class="text-capitalize bg-info text-white">Update User Info</q-btn>
          </q-card-actions>
        </q-card>
      </div>
      <div class="col-lg-4 col-md-4 col-xs-12 col-sm-12">

        <q-card class="card-bg text-white">
          <q-card-section class="text-center bg-transparent">
            <q-avatar size="100px" class="shadow-10">
              <img src="https://mblogthumb-phinf.pstatic.net/MjAxOTEwMjlfNDUg/MDAxNTcyMzI5NDcwNjIz.aW2F-SaHTjtOHNUlRixK7I_scEWzQDe7k-JHLkxj9_wg.fKoqWcVf8Y-vVCKGpIqUCy--2rC8Na4pHoGawaOwmVcg.PNG.moonkuki/SE-c0ad31f7-b153-4905-9f10-9d81b853e1e6.png?type=w800">
            </q-avatar>
            <div class="text-subtitle2 q-mt-lg">by 쬬르디</div>
            <div class="text-h6 q-mt-md">죠르디 사원</div>
          </q-card-section>
          <q-card-section>
            <div class="text-body2 text-justify">
                서울중앙지방법원은 15일 넷플릭스가 SK브로드밴드를 상대로 제기한 '채무부존재 확인의 소' 민사소송 두번째 변론기일을 열었다.

지난해 10월 30일 1차 변론기일 이후 열린 이번 2차 변론기일에는 넷플릭스의 법률대리인인 김앤장과 SK브로드밴드의 법률대리인 세종 변호사들이 출석해 각각 주요 쟁점에 대한 주장을 펼쳤다.

이날 가장 첨예한 쟁점은 '망 이용대가 지불의 정당성'으로 1차 변론기일에서 재판부가 지적한 내용에 대한 각각의 주장으로 점철됐다.

1차 변론기일 당시 재판부는 넷플릭스의 주장과 같이 '망중립성이 망을 무료로 이용할 수 있는 논거가 되는지'와 '넷플릭스와 SK브로드밴드의 연결방식에 따른 기술적 해석', '협상의무의 부존재 확인과 관련된 방송통신위원회의 재정절차의 법리적 해석' 등을 요구했다.

우선 '망중립성'이 이번 사건과 어떤 연관을 갖는지다.
            </div>
          </q-card-section>
        </q-card>
      </div>

      <div class="col-lg-8 col-md-8 col-xs-12 col-sm-12">
        <q-card class="card-bg text-white">
          <q-card-section class="text-h6 q-pa-sm">
            <div class="text-h6">비밀번호 수정</div>
          </q-card-section>
          <q-card-section class="q-pa-sm row">
            <q-item class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <q-item-section>
                현재 비밀번호
              </q-item-section>
            </q-item>
            <q-item class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <q-item-section>
                <q-input type="password" dark dense outlined color="white" round v-model="password_dict.current_password"
                         label="현재 비밀번호"/>
              </q-item-section>
            </q-item>
            <q-item class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <q-item-section>
                새 비밀번호
              </q-item-section>
            </q-item>
            <q-item class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <q-item-section>
                <q-input type="password" dark dense outlined color="white" round v-model="password_dict.new_password"
                         label="새 비밀번호"/>
              </q-item-section>
            </q-item>
            <q-item class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <q-item-section>
                비밀번호 확인
              </q-item-section>
            </q-item>
            <q-item class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <q-item-section>
                <q-input type="password" dark dense outlined round color="white" v-model="password_dict.confirm_new_password"
                         label="비밀번호 확인"/>
              </q-item-section>
            </q-item>
          </q-card-section>
          <q-card-actions align="right">
            <q-btn class="text-capitalize bg-info text-white">Change Password</q-btn>
          </q-card-actions>

        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
    export default {
        name: "UserProfile",
        data() {
            return {
                user_details: {},
                password_dict: {}
            }
        }
    }
</script>

<style scoped>

  .card-bg {
    background-color: #162b4d;
  }
</style>
