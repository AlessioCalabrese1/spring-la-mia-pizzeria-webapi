<template>
  
</template>

<script>
import axios from 'axios';
import { response } from 'express';

const API_URL = "http://localhost:8080/api/1";

export default {
    name: "Main",
    data(){
        return{
            pizze: [],
        }
    },

    methods: {
        getAllPizza(){
            axios.get(API_URL + "/pizzeria")
            .then(response => {
                console.log(response);
            }).catch(err =>{
                console.log(err);
            })
        }
    }
}
</script>

<style scoped>

</style>