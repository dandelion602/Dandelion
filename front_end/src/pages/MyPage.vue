<template>
  <div class="row">
    <div class="col flex flex-center">

      <q-btn to="/profile"
        size="100px"
        round
        icon="perm_identity"
      >
        <q-tooltip content-class="bg-primary" class="ccc">
          개인 정보 수정
        </q-tooltip>
      </q-btn>


    </div>
    <div class="col flex flex-center">
      <q-btn
        size="100px"
        round
        icon="shopping_cart"
      >
        <q-tooltip content-class="bg-primary">
          거래 내역
        </q-tooltip>
      </q-btn>
    </div>
  </div>

</template>
<script>
export default{
  data() {
    return {
      icon_image_size: "100px"
    }
  }
}
</script>
<style lang="sass" scoped>
.row
  height: 50em


</style>

