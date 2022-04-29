import React, { useEffect, useState } from 'react'
import { Box, Typography } from '@mui/material';

import makeStyles from './styles'
import { useSelector, useDispatch } from 'react-redux';

function CategoryComponent(props) {
    const { category } = props;
    const [product, setProduct] = useState(null);
    const styles = makeStyles();
    const products = useSelector(state => state.Home.allProductsArray);
    const serverAddress = useSelector(state => state.Home.serverAddress);
    const dispatch = useDispatch();

    useEffect(() => {
        if (products) {
            for (const item of products) {
                if (item.style == category) {
                    setProduct(item);
                    break;
                }
            }
        }
    }, [products, category])

    return (
        <Box sx={styles.container}>
            <img src={`${serverAddress + product?.filename}`}></img>
            <Typography sx={styles.title}>{category}</Typography>
        </Box>
    )
}

export default CategoryComponent