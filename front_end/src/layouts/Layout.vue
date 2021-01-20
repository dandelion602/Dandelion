<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <!-- <q-btn dense flat round icon="menu" @click="left = !left" /> -->
        

        <q-toolbar-title >
          <q-avatar >
            <img src="https://cdn.quasar.dev/logo/svg/quasar-logo.svg"  >
          </q-avatar>
          DandeilOn
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer show-if-above v-model="left" side="left" bordered>
      <!-- drawer content -->
              <q-scroll-area style="height: calc(100% - 150px); margin-top: 150px; border-right: 1px solid #ddd">
          <q-list padding>
            <!-- <q-item clickable v-ripple router :to="{name: 'main'}"> -->
            <q-item clickable v-ripple :to="{ name: 'main' }">
              <q-item-section avatar>
                <q-icon name="inbox" />
              </q-item-section>

              <q-item-section>
                내 정보
              </q-item-section>
            </q-item>
<!-- active 클릭 되있는 상태를 표시하려면 -->
            <q-item clickable v-ripple>
              <q-item-section avatar>
                <q-icon 
                name="star"
                 />
              </q-item-section>

              <q-item-section>
                거래 현황
              </q-item-section>
            </q-item>

            <q-item clickable v-ripple>
              <q-item-section avatar>
                <q-icon name="send" />
              </q-item-section>

              <q-item-section>
                아 뭘넣지
              </q-item-section>
            </q-item>

            <q-item clickable v-ripple>
              <q-item-section avatar>
                <q-icon name="drafts" />
              </q-item-section>

              <q-item-section>
                아이디어가 필요해
              </q-item-section>
            </q-item>
          </q-list>
        </q-scroll-area>


      <!-- header-img section -->
        <q-img class="absolute-top" src="https://cdn.quasar.dev/img/material.png" style="height: 150px">
          <div class="absolute-bottom bg-transparent">
            <q-avatar size="56px" class="q-mb-sm">
              <!-- <img src="https://cdn.quasar.dev/img/boy-avatar.png"> -->
              <img src="https://item.kakaocdn.net/do/a56e6ddd117688df80be93b1154a9856f43ad912ad8dd55b04db6a64cddaf76d">
            </q-avatar>
            <div class="text-weight-bold">Razvan Stoenescu</div>
            <div>@rstoenescu</div>
          </div>
        </q-img>
        
        <!-- <div class="absolute-bottom">
          <q-avatar size="156px">
            <img src="https://static.thenounproject.com/png/641028-200.png">
          </q-avatar>

        </div> -->

    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script>
export default {
  data () {
    return {
      left: false,
    }
  }
}
</script>