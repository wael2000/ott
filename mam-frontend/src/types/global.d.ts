export {};

declare global {
  interface Media {
    id: number;
    name: string;
    description: string,
    hour: number,
    minute: number,
    thumbnailMobile: string,
    thumbnailWeb: string,
    thumbnailTv: string,
    type: string,
  }

  interface Collection {

  }

}
