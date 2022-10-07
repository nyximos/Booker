<script setup>
import { ref } from "vue";

import axios from "axios";

const username = ref("");
const password = ref("");

const login = function () {
  const data = {
    username: username.value,
    password: password.value,
  };

  const config = {
    headers: {
      "Content-Type": "multipart/form-data",
    },
  };

  axios
    .post("/api/login", data, config)
    .then((res) => {
      window.location.href = "/";
    })
    .catch((err) => {
      const url = decodeURIComponent(err.request.responseURL);
      const afterStr = url.split("=");
      const message = afterStr[1].replaceAll("+", " ");
      alert(message);
    });
};
</script>

<template>
  <div>
    <p>안녕하세요</p>
    <div>
      <input type="email" name="username" v-model="username" />
    </div>
    <div>
      <input type="password" name="password" v-model="password" />
    </div>
    <div>
      <button @click="login()">로그인</button>
    </div>
    <div>
      <RouterLink to="/join">회원가입</RouterLink>
      <a href="/api/oauth2/authorization/google">구글 로그인</a>
    </div>
  </div>
</template>

<style scoped></style>
