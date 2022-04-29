import React, { useEffect, useState } from 'react';
import { Box } from '@mui/system';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import { useDispatch, useSelector } from 'react-redux';
import styles from './styles';
import createStyles from './containerStyles'; //this is needed to hide the second panel
import { Button, IconButton, Input, InputAdornment, Stack, Switch, TextField, Typography } from '@mui/material';
import GalleryItem from './GalleryItem/GalleryItem';
import { DesktopDatePicker } from '@mui/x-date-pickers';
import { updateGalleryProduct, uploadFile } from '../../../actions/productActions';
import { getUserData } from '../../../actions/authenticationActions';

function GalleryPanel(props) {
    const { value, index } = props;
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const [isEditOpen, setIsEditOpen] = useState(true);
    const [selectedIndex, setSelectedIndex] = useState(null);
    const [title, setTitle] = useState("");
    const [date, setDate] = useState(null);
    const [price, setPrice] = useState("");
    const [style, setStyle] = useState("");
    const [featured, setFeatured] = useState(false);
    const [description, setDescription] = useState("");
    const [width, setWidth] = useState(0);
    const [length, setLength] = useState(0);
    const [tags, setTags] = useState("");
    const productList = useSelector(state => state.Product.userProductList);
    const selectedProduct = useSelector(state => state.Product.gallerySelectedProduct);
    const serverAddress = useSelector(state => state.Home.serverAddress);
    const user = useSelector(state => state.Authentication.user);
    const dispatch = useDispatch();

    useEffect(() => {
        setTitle(selectedProduct.title);
        setDate(selectedProduct.date);
        setPrice(selectedProduct.price);
        setFeatured(selectedProduct.featured);
        setDescription(selectedProduct.description);
        setWidth(selectedProduct.width);
        setLength(selectedProduct.length);
        setTags(selectedProduct.tags);
    }, [selectedProduct]);

    useEffect(() => {
        dispatch(getUserData(user.email));
    }, [])

    const onGalleryItemClicked = (index) => {
        setSelectedIndex(index);

        //if being deslected then the sidebar should close
        if (index == null) {
            setIsSidebarOpen(false);
        } else {
            setIsSidebarOpen(true);
        }
    }

    /* this is the event handler for the upload button.
        files are returned in an array even if only one
        file is selected. */
    const onUploadButtonPressed = (event) => {
        const newImage = event.target.files[0];

        //prepare the image then send it off
        let formData = new FormData();
        formData.append("file", newImage, newImage.name);
        formData.append("user", new Blob([JSON.stringify(user)], { type: 'application/json' }));
        dispatch(uploadFile(formData));
    }

    const onSaveButtonClicked = (event) => {
        const tempProduct = {
            ...selectedProduct,
            title,
            date,
            price,
            style,
            featured,
            description,
            width,
            length,
            tags,
        }

        const data = {user, product: tempProduct};

        dispatch(updateGalleryProduct(data));
    }

    const onStyleChanged = (event) => {
        setStyle(event.target.value);
    }
    const onTagsChanged = (event) => {
        setTags(event.target.value);
    }

    const onLengthChanged = (event) => {
        setLength(parseInt(event.target.value));
    }

    const onWidthChanged = (event) => {
        setWidth(parseInt(event.target.value));
    }

    const onDescriptionChanged = (event) => {
        setDescription(event.target.value);
    }

    const onFeaturedChanged = (event) => {
        setFeatured(event.target.checked);
    }

    const onPriceChanged = (event) => {
        setPrice(event.target.value);
    }

    const onTitleChanged = (event) => {
        setTitle(event.target.value)
    }

    const onButtonPress = (event) => {
        setIsSidebarOpen(!isSidebarOpen);
    }

    const onDateChanged = (event) => {

    }

    const onEditButtonClicked = (event) => {
        setIsEditOpen(!isEditOpen);
    }

    const onBackButtonClicked = (event) => {
        setIsEditOpen(!isEditOpen);
    }

    return (
        <Box hidden={value == index ? false : true} sx={createStyles(value !== index)}>
            <Box padding={2} sx={isSidebarOpen ? styles.content : styles.contentExpanded}>
                <label htmlFor='contained-button-file-1'>
                    <Input accept="image/*" id="contained-button-file-1" type="file" sx={{ display: "none" }} onChange={onUploadButtonPressed} />
                    <Button variant='contained' component='span'>Upload</Button>
                </label>
                <hr />
                <Box sx={styles.imagesList}>
                    {productList?.map((item, arrayIndex) => {
                        return <GalleryItem clickAction={onGalleryItemClicked} currentIndex={selectedIndex} index={arrayIndex} key={arrayIndex} product={item} />
                    })}
                </Box>
            </Box>
            <Box sx={isSidebarOpen ? styles.rightSidebar : styles.rightSidebarClosed}>
                <Box id="actionBar" sx={styles.actionBar} >
                    <Stack direction="row"  >
                        <IconButton sx={!isEditOpen ? styles.backActionButton : { display: "none" }} onClick={onBackButtonClicked}>
                            <ArrowBackOutlinedIcon sx={styles.actionButton} />
                        </IconButton>
                        <IconButton sx={!isEditOpen ? { display: "none" } : styles.rightActionButton} onClick={onEditButtonClicked}>
                            <EditOutlinedIcon />
                        </IconButton >
                        <IconButton sx={!isEditOpen ? { display: "none" } : styles.actionButton}>
                            <DeleteOutlineOutlinedIcon sx={styles.actionButton} />
                        </IconButton>
                    </Stack>
                </Box>
                <Box sx={isEditOpen ? styles.sidebarInfoContainer : styles.sidebarInfoContainerHidden}>
                    <Box sx={styles.imageContainer}>
                        {productList && <img src={serverAddress + selectedProduct.filename} alt='selected image'></img>}
                    </Box>
                    <Typography>Title</Typography>
                    <Typography align='right'>{selectedProduct.title}</Typography>
                    <Typography>Price</Typography>
                    <Typography align='right'>{selectedProduct.price}</Typography>
                    <Typography>Size</Typography>
                    <Typography align='right'>{selectedProduct.width} x {selectedProduct.length}</Typography>
                    <Typography>Tags</Typography>
                    <Typography align='right'>{selectedProduct.tags}</Typography>
                    <Typography>Date Created</Typography>
                    <Typography align='right'>{selectedProduct.date.toString()}</Typography>
                    <Typography>Featured</Typography>
                    <Box id='toggleSwitchContainer' sx={styles.toggleSwitchContainer}>
                        <Switch size='small' checked={selectedProduct.featured} ></Switch>
                    </Box>
                    <Typography sx={styles.descriptionLabel}>Description</Typography>
                    <Typography sx={styles.descriptionText}>{selectedProduct.description}</Typography>
                </Box>
                <Box sx={isEditOpen ? styles.sidebarFormContainerHidden : styles.sidebarFormContainer}>
                    <Box sx={styles.formGroup}>
                        <Typography>Title</Typography>
                        <TextField size='small' value={title} onChange={onTitleChanged}></TextField>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Date Created</Typography>
                        <DesktopDatePicker
                            inputFormat="MM/dd/yyyy"
                            onChange={onDateChanged}
                            renderInput={(params) => <TextField {...params} />}
                        />
                    </Box>
                    <Box>
                        <Typography>Price</Typography>
                        <TextField size='small' label='$' sx={styles.priceTextField} value={price} onChange={onPriceChanged} ></TextField>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Style</Typography>
                        <TextField size="small" value={style} onChange={onStyleChanged}></TextField>
                    </Box>
                    <Box sx={styles.editToggleSwitchContainer}>
                        <Typography>Featured</Typography>
                        <Box id='toggleSwitchContainer' sx={styles.toggleSwitchContainer}>
                            <Switch size='small' checked={featured} onChange={onFeaturedChanged}></Switch>
                        </Box>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Description</Typography>
                        <TextField multiline rows={3} value={description} onChange={onDescriptionChanged}></TextField>
                    </Box>
                    <Box sx={styles.dimensionsContainer}>
                        <Box>
                            <Typography>Width</Typography>
                            <TextField
                                size='small'
                                InputProps={{ endAdornment: <InputAdornment position='end'>in</InputAdornment> }}
                                value={width}
                                onChange={onWidthChanged}
                            ></TextField>
                        </Box>
                        <Box>
                            <Typography>Length</Typography>
                            <TextField
                                size='small'
                                InputProps={{ endAdornment: <InputAdornment position='end'>in</InputAdornment> }}
                                value={length}
                                onChange={onLengthChanged}
                            ></TextField>
                        </Box>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Tags(Comma Separated) </Typography>
                        <TextField placeholder='Sky,Custom, ect..' size='small' value={tags} onChange={onTagsChanged}></TextField>
                    </Box>
                    <Button variant='contained' sx={styles.saveButton} size='small' onClick={onSaveButtonClicked}>Save Changes</Button>

                </Box>
            </Box>
        </Box>
    )
}

export default GalleryPanel