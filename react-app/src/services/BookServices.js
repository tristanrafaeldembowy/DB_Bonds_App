import { hostNameUrl } from "../config/api";
import axios from "axios";

export const getBooks = () => {
  const books = [{id:1,name:"Shyam",age:24}];
  //const pets = axios.get(`${hostNameUrl}/dogs`);
  return books;
}

export const getTransactionsByBookId = (Id) => {
    const books = [{id:1,name:"Shyam",age:24}];
    //const pets = axios.get(`${hostNameUrl}/dogs/Id`);
    return books;
  }

  export const getbooksByDate = (date) => {
    const books = [{id:1,name:"Shyam",age:24}];
    //const pets = axios.get(`${hostNameUrl}/dogs/Id`);
    return books;
  }

