import React from 'react'
import { Box } from '@mui/material';
import makeStyles from './styles';

function AdminGalleryItem(props) {
    const { index, currentIndex, clickAction, image } = props;
    const styles = makeStyles(index, currentIndex);

    const onElementClicked = (e) => {
        e.preventDefault();

        //if item already selected then return null to deselectit
        //else mark it selectrf
        if(index === currentIndex){
            clickAction(null);
        }else{
            clickAction(index);
        }
    }

    return (
        <Box sx={styles.container} onClick={onElementClicked}>
            {index}
        </Box>
    )
}

export default AdminGalleryItem