import { Box, Typography } from '@mui/material';
import React from 'react'

import makeStyles from './styles';
import Header from '../../components/Header/Header';
import { useSelector } from 'react-redux';
import HomeProduct from '../../components/HomeProduct/HomeProduct';

function Home() {
    const styles = makeStyles();
    const products = useSelector(state => state.Home.allProductsArray);

    return (
        <Box sx={styles.container}>
            <Header />
            <Box sx={styles.headingContainer}>
                <Typography variant='h2'>ART REIMAGINED</Typography>
            </Box>
            <Box sx={styles.productsContainer}>
                <Typography></Typography>
                <Box sx={styles.products}>
                    {products.map((item, index) => {
                        return <HomeProduct product={item} key={index} />
                    })}
                </Box>
            </Box>
        </Box>
    )
}

export default Home