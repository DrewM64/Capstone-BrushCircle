import React, { useState } from 'react';
import { Box, Typography } from '@mui/material';
import EmailIcon from '@mui/icons-material/Email';
import PaidIcon from '@mui/icons-material/Paid';
import TwitterIcon from '@mui/icons-material/Twitter';

import FeaturedImage from './FeaturedImage/FeaturedImage';
import GalleryImage from './GalleryImage/GalleryImage';
import Header from '../../components/Header/Header'

import makeStyles from './styles';
function UserProfile() {
  const nums = [1, 2, 3, 4];
  const nums2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  const styles = makeStyles();
  return (
    <Box sx={styles.container}>
      <Header />
      <Box sx={styles.innerContainer}>
        <Box sx={styles.infoContainer}>
          <Box sx={styles.userCard}>
            <Box sx={styles.userCardHeader}>
              <Box sx={styles.imageContainer}>
                <img src='stefan-stefancik-QXevDflbl8A-unsplash.jpg'></img>
              </Box>
              <Typography align='center' variant='h6'>Stacy Woodard</Typography>
              <Typography align='center' variant='caption'>Photographer</Typography>
            </Box>
            <Box sx={styles.productsTextContainer}>
              <Typography variant='subtitle1' align='center' >30 Products</Typography>
            </Box>
            <Box sx={styles.linksContainer}>
              <EmailIcon fontSize='small' sx={{ width: '100%' }}></EmailIcon>
              <Typography>somename@gmail.com</Typography>
              <PaidIcon fontSize='small'></PaidIcon>
              <Typography>$swoodard</Typography>
              <TwitterIcon fontSize='small'></TwitterIcon>
              <Typography>stazzywoo</Typography>
            </Box>
            <Box sx={styles.biographyContainer}>
              <Typography align='center'>Bio</Typography>
              <Typography align='left' >Lorem ipsum alca beta apha som
                more painting card terrace indo
                ishi alphaza lorem remi mus ipsu
                apha beta omega supreme reach
                rinnegan sharingon eternal mang</Typography>
            </Box>
          </Box>
        </Box>
        <Box sx={styles.contentContainer}>
          <Box sx={styles.featuredContainer} mb={4}>
            <Typography mb={2}>Featured Images</Typography>
            <Box sx={styles.featuredImages}>
              {nums.map((val, index) => {
                return <FeaturedImage number={val} key={index} />
              })}
            </Box>
          </Box>
          <Box sx={styles.galleryContainer}>
            <Typography mb={2}>Gallery</Typography>
            <Box sx={styles.galleryImages}>
              {nums2.map((val, index) => {
                return <GalleryImage number={val} key={index} />
              })}
            </Box>
          </Box>
        </Box>
      </Box>
    </Box>
  )
}

export default UserProfile