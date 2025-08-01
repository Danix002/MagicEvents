import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit } from '@fortawesome/free-solid-svg-icons';

const ImageEdit = ({src, alt, onEditClick}) => {
  const isValid = src && src.trim() !== '';
  return (
    <div className="relative w-full max-h-[48rem] min-h-21 rounded-md overflow-hidden border border-[#E4DCEF] ring ring-[#E4DCEF] ring-offset-2">
        {isValid ? (
            <img
                className="w-full min-h-21 border border-[#E4DCEF] rounded-md ring ring-[#E4DCEF] ring-offset-2 flex-auto max-h-[48rem] object-cover object-center"
                src={'data:image/*;base64,' + src}
                alt={alt}

            />
        ):(
            <span className="w-full h-full text-sm text-gray-500 text-center">{alt}</span>
        )}
      <button
        onClick={onEditClick}
        className="absolute top-2 right-2 w-8 h-8 flex items-center justify-center bg-white bg-opacity-75 rounded-full text-[#505458] hover:text-[#363540] shadow-md"
        aria-label="Modifica immagine"
      >
        <FontAwesomeIcon icon={faEdit} />
      </button>
    </div>
  );
}

export default ImageEdit;
