<template>
  <div class="q-pa-md" >
    <q-form @submit="onSubmit" class="q-gutter-md">
      <h2 class="title">상품 등록</h2>
        <!-- 사진업로드 -->

        <!-- 이름 작성 -->
      <h5> 상품명 </h5>
      <q-input
        name="name"
        v-model="name"
        color="primary"
        label="이름"
        filled
      />
      <!-- <q-input 
      v-model="text" 
      label="위로 할까 아래로 할까 고민이네 뭐하지" 
      :dense="dense
      "/> -->
      <h5> 가격 </h5>
        <q-input 
          v-model.number="price"
          type='number'
          label="가격"
          filled
          />

      <h5>상품설명</h5>
        <q-input 
          v-model="textarea"
          style="max-width: 600px"
          filled
          type="textarea"
          label="상품설명"
        />
        <h5> 이미지 업로드 </h5>
        <!-- <div class="q-gutter-md row items-start">
          <q-input
            @input="val => { file = val[0] }"
            filled
            type="file"
            hint="클릭하여 이미지를 올리세요"
          />
        </div> -->

        <q-uploader
        url="http://localhost:9000/upload"
        color="teal"
        flat
        bordered
        style="max-width: 300px"
      />
      
      
      
      
      <!--  -->
      <div>
        <q-btn label="등록" type="submit" color="primary"/>
      </div>
    <q-btn color="primary" @click="postTest">포스트 테스트</q-btn>
    </q-form>

    <q-card v-if="submitResult.length > 0" flat bordered class="q-mt-md bg-grey-2">
      <q-card-section>Submitted form contains the following formData (key = value):</q-card-section>
      <q-separator />
      <q-card-section class="row q-gutter-sm items-center">
        <div
          v-for="(item, index) in submitResult"
          :key="index"
          class="q-px-sm q-py-xs bg-grey-8 text-white rounded-borders text-center text-no-wrap"
        >{{ item.name }} = {{ item.value }}
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      name: '',
      submitResult: [],
      text: '',
      textarea: '',
      ph: '',
      price:'',
      file: null,

      dense : false
    }
  },

  methods: {
    onSubmit (evt) {
      const formData = new FormData(evt.target)
      const submitResult = []

      for (const [ name, value ] of formData.entries()) {
        submitResult.push({
          name,
          value
        })
      }

      this.submitResult = submitResult
    },
  postTest() {
    axios
      .post("https://reqres.in/api/users",{
        "name": "morpheus",
        "job": "leader"
      })
      .then(res => {
        console.log(res)
      })
      .catch(err =>{
        console.log(res)
      }) 
  }
  },
}
</script>


<style lang="scss" scoped>
    .q-pa-md{
        padding: 15px 40%;
        max-width: 50%;
        height: 100vhs;
        display: flex;
        
        .q-input{
          max-width: 600px;
        }
    }
    .title{
      text-align: center;
    }
</style>