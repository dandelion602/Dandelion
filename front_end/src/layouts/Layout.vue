<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <!-- <q-btn dense flat round icon="menu" @click="left = !left" /> -->
        <span>
        <q-toolbar-title class="q-ma-sm">
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo/svg/quasar-logo.svg"  >
          </q-avatar>
          DandeilOn
        </q-toolbar-title>
        </span>
      </q-toolbar>
    </q-header>

    <q-drawer show-if-above v-model="left" side="left" bordered>
      <!-- drawer content -->
        <q-scroll-area style="height: calc(100% - 150px); margin-top: 150px; border-right: 1px solid #ddd">
          <q-list padding>
            <!-- <q-item clickable v-ripple router :to="{name: 'main'}"> -->
            <q-item clickable v-ripple :to="{ name: 'PageIndex' }">
              <q-item-section avatar>
                <q-icon name="inbox" />
              </q-item-section>

              <q-item-section>
                메인페이지
              </q-item-section>
            </q-item>
<!-- active 클릭 되있는 상태를 표시하려면 -->
            <q-item clickable v-ripple :to="{ name: 'myPage'}">
              <q-item-section avatar>
                <q-icon
                name="star"
                 />
              </q-item-section>

              <q-item-section>
                마이 페이지
              </q-item-section>
            </q-item>

            <q-item clickable v-ripple :to=" { name: 'Stuff' }">
              <q-item-section avatar>
                <q-icon name="send"/>
              </q-item-section>

              <q-item-section>
                물품등록
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
      <!-- route 되는 페이지를 로드시킨다 -->
      <transition
      :name="transitionName">
      <router-view />
      </transition>
    </q-page-container>

  </q-layout>
</template>

<script>
export default {
  data () {
    return {
      left: false,
      transitionName: 'slide-left'
    }
  },
  watch:{
    $route (to, from){
      this.transitionName = to.name = 'PageIndex' ? 'slide-right' : 'slide-left'
      // console.log(to.name)
    }
  }
}
</script>

<style lang="scss" scoped>
.slide-left-enter-active,
.slide-left-leave-active,
.slide-right-enter-active,
.slide-right-leave-active{
  transition-duration: 0.5s;
  transition-property: height, opacity, transform;
  /* transition-timing-function: cubic-bezier(0.55,0,0.1,1); */
  overflow: hidden;
}

.slide-left-enter,
.slide-right-leave-active{
  opacity:0;
  transform: translate(100%,0);
}

.slide-left-leave-active,
.slide-right-enter{
  opacity: 0;
  transform: translate(-100%,0);
}
</style>
