<template>
  <q-page class="">
    <div class="row">
      <div class="col-9 q-pa-md">
        <h3>상품 상세 페이지</h3>
        <div class="row">
          <div class="col-6">
            <q-img
              contain
              :src="curItem.itemImg"
              :ratio="1"
            />
          </div>
          <div class="col-6 q-px-md">
            <div class="text-h4 q-mb-none q-mt-md">{{curItem.title}}</div>
            <div class="text-subtitle1 q-mt-sm">{{curItem.desc}}</div>
            <div class="text-h4 q-mt-xl text-right">{{numberWithCommas(curItem.price)}}원</div>
            <div class="text-right">
              <q-btn color="primary q-mt-xl " :to="`/buy/${curItem.id}`">구매하기</q-btn>
            </div>
          </div>
        </div>
        
        
      </div>
      <div class="col-3">
        <q-list bordered separator class="cardArea ">
          <q-item clickable v-ripple v-for="item in itemList" :key="item.id" @click="onDetail(item.id)">
            <q-item-section avatar>
              <q-avatar rounded>
                <q-img
                  :src="item.itemImg"
                  :ratio="1"
                />
              </q-avatar>
            </q-item-section>
            <q-item-section>
              {{item.title}}
              <q-item-label caption>Caption</q-item-label>
            </q-item-section>
            
            <q-item-section side>{{numberWithCommas(item.price)}}원</q-item-section>
          </q-item>
        </q-list>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'Detail',
  data () {
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
        {
          id: 11,
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
          id: 12,
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
          id: 13,
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
          id: 14,
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
          id: 15,
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
          id: 16,
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
          id: 17,
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
  computed: {
    itemId () {
      return this.$route.params.itemId
    },
    curItem () {
      return this.itemList.filter(i => i.id == this.itemId)[0]
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
</style>