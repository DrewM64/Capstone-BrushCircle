import axios from "axios";

const serverURL = "http://localhost:8000";
const API = axios.create({ baseURL: serverURL });

// authentication
export const register = (formData) => API.post('/user/register',formData);
export const login = (formData) => API.post('/user/login', formData);
export const update = (newUserObject) => API.post('/user/update', newUserObject);
export const uploadProfilePhoto = (formData) => API.post('/user/newprofilephoto', formData);
export const resetProfilePhoto = (user) => API.post('/user/resetprofilephoto', user);

// product
export const uploadFileToServer = (formData) => API.post('/product/upload', formData);