import React, { useEffect, useState } from 'react';
import { Box, Typography } from '@mui/material';
import EmailIcon from '@mui/icons-material/Email';
import PaidIcon from '@mui/icons-material/Paid';
import TwitterIcon from '@mui/icons-material/Twitter';

import FeaturedImage from './FeaturedImage/FeaturedImage';
import GalleryImage from './GalleryImage/GalleryImage';
import Header from '../../components/Header/Header';
import { getUserProfile, getProductInfo } from '../../actions/homeActions';

import makeStyles from './styles';
import { useNavigate, useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
function UserProfile() {
  const nums = [1, 2, 3, 4];
  const nums2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  const styles = makeStyles();
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const userProfileObject = useSelector(state => state.Home.userProfileObject);
  const userProfileProducts = useSelector(state => state.Home.userProfileProducts);
  const serverAddress = useSelector(state => state.Home.serverAddress);
  const { email } = useParams();

  useEffect(() => {
    dispatch(getUserProfile(email));
  }, [email])

  const onItemClicked = (product) => {
    dispatch(getProductInfo(product));
    navigate("/imageview");
  }

  return (
    <Box sx={styles.container}>
      <Header />
      <Box sx={styles.innerContainer}>
        <Box sx={styles.infoContainer}>
          <Box sx={styles.userCard}>
            <Box sx={styles.userCardHeader}>
              <Box sx={styles.imageContainer}>
                <img src={`${serverAddress}${userProfileObject?.profileImageName}`}></img>
              </Box>
              <Typography align='center' variant='h6'>{`${userProfileObject?.firstName} ${userProfileObject?.lastName}`}</Typography>
              <Typography align='center' variant='caption'>{userProfileObject?.title}</Typography>
            </Box>
            <Box sx={styles.productsTextContainer}>
              <Typography variant='subtitle1' align='center' >{`${userProfileProducts?.length} Products`} </Typography>
            </Box>
            <Box sx={styles.linksContainer}>
              <EmailIcon fontSize='small' sx={{ width: '100%' }}></EmailIcon>
              <Typography>{userProfileObject?.email}</Typography>
              <PaidIcon fontSize='small'></PaidIcon>
              <Typography>{userProfileObject?.cashapp}</Typography>
              <TwitterIcon fontSize='small'></TwitterIcon>
              <Typography>{userProfileObject?.twitter}</Typography>
            </Box>
            <Box sx={styles.biographyContainer}>
              <Typography align='center'>Bio</Typography>
              <Typography variant='caption' align='left'>{userProfileObject?.biography}</Typography>
            </Box>
          </Box>
        </Box>
        <Box sx={styles.contentContainer}>
          <Box sx={styles.featuredContainer} mb={4}>
            <Typography mb={2}>Featured Images</Typography>
            <Box sx={styles.featuredImages}>
              {userProfileProducts?.map((item, index) => {
                if(!item.featured){return null}
                return <FeaturedImage key={index} action={onItemClicked} product={item} />
              })}
            </Box>
          </Box>
          <Box sx={styles.galleryContainer}>
            <Typography mb={2}>Gallery</Typography>
            <Box sx={styles.galleryImages}>
              {userProfileProducts?.map((item, index) => {
                return <GalleryImage key={index} action={onItemClicked} product={item} />
              })}
            </Box>
          </Box>
        </Box>
      </Box>
    </Box>
  )
}

export default UserProfile