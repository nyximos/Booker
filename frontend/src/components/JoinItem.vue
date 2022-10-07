<script setup>
import { ref, watch } from "vue";

import axios from "axios";

const email = ref("");
const password = ref("");
const name = ref("");
const nickname = ref("");
const checkEmailStatus = ref(false);

watch(email, () => {
  checkEmailStatus.value = false;
});

const join = function () {
  if (email.value != "" && checkEmailStatus.value == true) {
    const data = {
      email: email.value,
      password: password.value,
      name: name.value,
      nickname: nickname.value,
    };

    const config = {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    };

    axios
      .post("/api/join", data, config)
      .then((res) => {
        window.location.href = "/";
      })
      .catch((err) => {
        console.log(err);
      });
  } else {
    alert("이메일 중복체크를 하세요!");
  }
};

const check = function () {
  axios
    .get("/api/join/email", { params: { email: email.value } })
    .then((res) => {
      if (res.data.statusEnum == "OK") {
        alert("사용가능한 이메일입니다.");
        checkEmailStatus.value == true;
      } else {
        alert(res.data.message);
        email.value = "";
      }
    })
    .catch((err) => {
      console.log(err);
    });
};
</script>

<template>
  <div>
    <p>안녕하세요</p>
    <div>
      <div>이메일</div>
      <input type="email" name="email" v-model="email" />
      <button @click="check()">중복체크</button>
    </div>
    <div>
      <div>비밀번호</div>
      <input type="password" name="password" v-model="password" />
    </div>
    <div>
      <div>이름</div>
      <input type="text" name="name" v-model="name" />
    </div>
    <div>
      <div>닉네임</div>
      <input type="text" name="nickname" v-model="nickname" />
    </div>
    <div>
      <button @click="join()">회원가입</button>
    </div>
  </div>
</template>

<style scoped></style>
