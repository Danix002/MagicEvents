import defaultImage from '../../assets/magicevents-logo.png';

const Image = ({ src, alt = 'thumbnail', onClick }) => {
	const imageSrc =
		src && src.trim() !== ''
			? 'data:image/*;base64,' + src
			: defaultImage;

	return (
		<img
			onClick={onClick}
			className="w-full border border-[#E4DCEF] rounded-md ring ring-[#E4DCEF] ring-offset-2 flex-auto max-h-[48rem] object-cover"
			src={imageSrc}
			alt={alt}
		/>
	);
};

export default Image;
