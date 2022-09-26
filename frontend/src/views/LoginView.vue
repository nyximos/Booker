<script setup>
import LoginItem from "../components/LoginItem.vue";
</script>

<template>
  <div class="about">
    <LoginItem />
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
