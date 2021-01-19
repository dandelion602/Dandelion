<template>
  <q-page class="">
    <div class="row">
      <div v-for="item in itemList" :key="item.id" class="col-4 cardArea">
        <q-card class="myCard" @click="onDetail(item.id)">


          <q-img
            :src="item.itemImg"
            :ratio="1"
          />


          <q-card-section>
            <div class="text-h6">{{item.title}}</div>
            <div class="text-subtitle2">by {{item.seller.name}}</div>
            <div class="text-h6 text-right">{{numberWithCommas(item.price)}}원</div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            {{ item.desc }}
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'PageIndex',
  data() {
    return {
      itemList: [
        {
          id: 1,
          title: '마이너스통장 팝니다',
          price: 100000,
          desc: '한 -10만원정도 있어요 사주세요',
          itemImg: 'https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F270B004E569277FA18FDCB',
          seller: {
            id: 1,
            name: '신용불량자'
          }
        },
        {
          id: 2,
          title: '금빛시티에서 공짜로 얻은 자전거',
          price: 1000000,
          desc: '별로 안탔어요',
          itemImg: 'https://m.benerobike.com/web/product/big/201805/10_shop1_242570.jpg',
          seller: {
            id: 2,
            name: '지우'
          }
        },
        {
          id: 3,
          title: 'LG 그램 17인치',
          price: 2548000,
          desc: '대학교가서 공부하라고 삼촌이 사줬는데 자퇴했어요',
          itemImg: 'https://images-na.ssl-images-amazon.com/images/I/71%2BEwud0jCL._AC_SL1497_.jpg',
          seller: {
            id: 3,
            name: '음악할거야'
          }
        },
        {
          id: 4,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 4,
            name: '판매자4'
          }
        },
        {
          id: 5,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 5,
            name: '판매자5'
          }
        },
        {
          id: 6,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 6,
            name: '판매자6'
          }
        },
        {
          id: 7,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 7,
            name: '판매자7'
          }
        },
        {
          id: 8,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 8,
            name: '판매자8'
          }
        },
        {
          id: 9,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 9,
            name: '판매자9'
          }
        },
        {
          id: 10,
          title: '팔아요',
          price: 0,
          desc: '',
          itemImg: 'https://tntwatches.in/image/cache/placeholder-550x550.png',
          seller: {
            id: 10,
            name: '판매자10'
          }
        },
      ]
    }
  },
  methods : {
    onDetail (itemId) {
      this.$router.push(`/detail/${itemId}`)
    },
    numberWithCommas(num) {
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
  }
}
</script>
<style lang="scss" scoped>
  .cardArea {
    padding: 30px;
    .myCard {
      cursor: pointer;
      transition: all .2s ease-in-out;
      &:hover {
        transform: scale(1.03);
      }
    }
  }
</style>