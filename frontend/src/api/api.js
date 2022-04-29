import axios from "axios";

const serverURL = "http://localhost:8000";
const API = axios.create({ baseURL: serverURL });

// authentication
export const register = (formData) => API.post('/user/register',formData);
export const login = (formData) => API.post('/user/login', formData);
export const update = (newUserObject) => API.post('/user/update', newUserObject);
export const uploadProfilePhoto = (formData) => API.post('/user/newprofilephoto', formData);
export const resetProfilePhoto = (user) => API.post('/user/resetprofilephoto', user);
export const getUser = (email) => API.post('/user/get', email, {headers: {'Content-Type': 'application/json'}});

// product
export const uploadFileToServer = (formData) => API.post('/product/upload', formData);
export const getProduct = (product) => API.post('/product/get', product);
export const updateProduct = (data) => API.post('/product/update', data);
export const deleteProduct = (data) => API.post('/product/delete', data);

// home
export const getAllProducts = () => API.get('/home/products');
export const fetchHomeData = () => API.get('/home/categories');
export const fetchExploreData = () => API.get('/explore/home');
export const fetchSearchResults = (query) => API.get('/search', query);

//admin
export const fetchAllUsers = (admin) => API.post('/admin/get', admin);
export const fetchUserSearch = (data) => API.post('admin/search', data);
export const deleteUser = (data) => API.post('/admin/delete', data);
export const createUser = (data) => API.post('/admin/createuser', data);