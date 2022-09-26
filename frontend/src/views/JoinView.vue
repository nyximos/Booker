<script setup>
import JoinItem from "../components/JoinItem.vue";
</script>

<template>
  <div class="about">
    <JoinItem />
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
