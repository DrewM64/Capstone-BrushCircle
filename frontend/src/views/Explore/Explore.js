import { Box, Typography } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { useDispatch } from 'react-redux';
import debug from "debug";

import makeStyles from './styles';
import Header from '../../components/Header/Header';
import { useSelector } from 'react-redux';
import HomeProduct from '../../components/HomeProduct/HomeProduct';
import { getProductsList, getHomeData } from "../../actions/homeActions";
import { Link } from 'react-router-dom';
import CategoryComponent from "../../components/CategoryComponent/CategoryComponent";

function Explore() {
    const [categoriesReduced, setCategoriesReduced] = useState([]);
    const styles = makeStyles();
    const products = useSelector(state => state.Home.allProductsArray);
    const categories = useSelector(state => state.Home.homeCategoriesArray);
    const dispatch = useDispatch();
    const output = debug("home");

    useEffect(() => {
        dispatch(getProductsList());
        dispatch(getHomeData());
    }, [])

    useEffect(() => {
        if(categories){
            let index = 1;
            let reducedItems = []
            for(const item of categories){
                if(index >= 4){
                    continue;
                }

                if(item == ""){
                    continue;
                }
                reducedItems.push(item);
                index++;
            }
            setCategoriesReduced(reducedItems);
        }
    }, [categories])

    return (
        <Box sx={styles.container}>
            <Header />
            <Box sx={styles.headingContainer}>
                <Typography variant='h2'>Discover Amazing Art</Typography>
            </Box>
            {/* <Box sx={styles.categoriesContainer}>
                <Box sx={styles.linksContainer}>
                    <Typography>Popular Categories</Typography>
                    <Link to="/explore">More</Link>
                </Box>
                <Box sx={styles.categories}>
                    {categoriesReduced?.map((item, index,) => {
                        return <CategoryComponent key={index} category={item} />
                    })}
                </Box>
            </Box> */}
            <Box sx={styles.productsContainer}>
                <Box sx={styles.exploreTextContainer}>
                    <Link to="/explore">Explore</Link>
                </Box>
                <Box sx={styles.products}>
                    {products?.map((item, index) => {
                        return <HomeProduct product={item} key={index} />
                    })}
                </Box>
                <Box sx={styles.moreLink}> 
                    <Link to="/explore">More</Link>
                </Box>
            </Box>
        </Box>
    )
}

export default Explore;